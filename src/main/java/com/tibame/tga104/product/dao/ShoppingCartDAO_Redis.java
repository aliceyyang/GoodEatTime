package com.tibame.tga104.product.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.product.vo.ShoppingCartVO;

@Repository
public class ShoppingCartDAO_Redis implements ShoppingCartDAO {

	@Resource(name="shoppingCartTemplate")
	RedisTemplate<Integer, HashMap<Integer, Integer>> redisTemplate;

	@Override
	public ShoppingCartVO insert(ShoppingCartVO shoppingCartVO) {
		HashOperations<Integer, Integer, Integer> ops = redisTemplate.opsForHash();
		boolean insert = ops.putIfAbsent(shoppingCartVO.getMemberNo(), shoppingCartVO.getProdNo(),
				shoppingCartVO.getProdQty());
		return insert ? shoppingCartVO : null;
	}

	@Override
	public ShoppingCartVO update(ShoppingCartVO shoppingCartVO) {
		HashOperations<Integer, Integer, Integer> ops = redisTemplate.opsForHash();
		ops.put(shoppingCartVO.getMemberNo(), shoppingCartVO.getProdNo(),
				shoppingCartVO.getProdQty());
		return shoppingCartVO;
	}

	@Override
	public boolean delete(Integer memberNo, Integer prodNo) {
		HashOperations<Integer, Integer, Integer> ops = redisTemplate.opsForHash();
		return ops.delete(memberNo, prodNo)==1;
	}

	@Override
	public ShoppingCartVO findByPrimaryKey(Integer memberNo, Integer prodNo) {
		Integer prodQty = (Integer) redisTemplate.opsForHash().get(memberNo, prodNo);
		if (prodQty != null) {
			ShoppingCartVO vo = new ShoppingCartVO();
			vo.setMemberNo(memberNo);
			vo.setProdNo(prodNo);
			vo.setProdQty(prodQty);
			return vo;
		}
		return null;
	}

	@Override
	public List<ShoppingCartVO> getAll() {
		// TODO Auto-generated method stub
		System.out.println("no need for this method");
		return null;
	}

	
//	public List<ShoppingCartVO> findByMemberNo(Integer memberNo) {
//		System.out.println("no need for this method");
//		return null;
//	}
	@Override
	public Map<Integer, Integer> findByMemberNo(Integer memberNo) {
		HashOperations<Integer, Integer, Integer> ops = redisTemplate.opsForHash();
		return ops.entries(memberNo);
	}
	
	public Integer getSumByMemberNo(Integer memberNo) {
		Map<Integer, Integer> all = findByMemberNo(memberNo);
		Iterator<Integer> iterator = all.keySet().iterator();
		int i = 0;
		while (iterator.hasNext()) {
			i+=all.get(iterator.next());
		}
		return i;
	}

}
