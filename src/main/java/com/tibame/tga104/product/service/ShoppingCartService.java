package com.tibame.tga104.product.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.product.dao.ProdInfoDAO;
import com.tibame.tga104.product.dao.ShoppingCartDAO;
import com.tibame.tga104.product.dao.ShowProdInMallDAO;
import com.tibame.tga104.product.helper.ShoppingCartItem;
import com.tibame.tga104.product.helper.ShoppingCartWrapper;
import com.tibame.tga104.product.vo.ShoppingCartVO;
import com.tibame.tga104.product.vo.ShowProdInMallVO;

@Service
public class ShoppingCartService {
	@Autowired
	private ShoppingCartDAO dao;
	@Autowired
	private ShowProdInMallDAO showProdInMallDAO;
	
	@Transactional
	public ShoppingCartVO insert(ShoppingCartVO shoppingCartVO) {
		if (shoppingCartVO == null || shoppingCartVO.getMemberNo() == null || shoppingCartVO.getProdNo() == null
				|| shoppingCartVO.getProdQty() == null) {
			return null;
		}
		if (shoppingCartVO.getMemberNo() < 1 || shoppingCartVO.getProdNo() < 1 || shoppingCartVO.getProdQty() < 1) {
			return null;
		}
		ShoppingCartVO temp = dao.findByPrimaryKey(shoppingCartVO.getMemberNo(), shoppingCartVO.getProdNo());
		if (temp == null) {
			return dao.insert(shoppingCartVO);
		}
		return null;
	}

	@Transactional
	public ShoppingCartVO update(ShoppingCartVO shoppingCartVO) {
		if (shoppingCartVO == null || shoppingCartVO.getMemberNo() == null || shoppingCartVO.getProdNo() == null
				|| shoppingCartVO.getProdQty() == null) {
			return null;
		}
		if (shoppingCartVO.getMemberNo() < 1 || shoppingCartVO.getProdNo() < 1 || shoppingCartVO.getProdQty() < 1) {
			return null;
		}
		ShoppingCartVO temp = dao.findByPrimaryKey(shoppingCartVO.getMemberNo(), shoppingCartVO.getProdNo());
		if (temp != null) {
			return dao.update(shoppingCartVO);
		}
		return null;
	}

	@Transactional
	public boolean delete(Integer memberNo, Integer prodNo) {
		if (memberNo == null || prodNo == null) {
			return false;
		}
		ShoppingCartVO temp = dao.findByPrimaryKey(memberNo, prodNo);
		if (temp != null) {
			return dao.delete(memberNo, prodNo);
		}
		return false;
	}

	public ShoppingCartVO findByPrimaryKey(Integer memberNo, Integer prodNo) {
		if (memberNo != null && prodNo != null) {
			return dao.findByPrimaryKey(memberNo, prodNo);
		}
		return null;
	}

	public List<ShoppingCartVO> getAll() {
		return dao.getAll();
	}

	public Map<Integer, Integer> findByMemberNo(Integer memberNo) {
		if (memberNo != null) {
			return dao.findByMemberNo(memberNo);
		}
		return null;
	}
	
	public Integer getSumByMemberNo(Integer memberNo) {
		return dao.getSumByMemberNo(memberNo);
	}

	public Collection<ShoppingCartWrapper> convert(Map<Integer, Integer> memberCart) {
		if (memberCart == null) {
			return null;
		}
		Iterator<Integer> iterator = memberCart.keySet().iterator();
		Map<Integer, ShoppingCartWrapper> result = new HashMap<>();
		while (iterator.hasNext()) {
			Integer prodNo = iterator.next();
			ShowProdInMallVO vo = showProdInMallDAO.select(prodNo);
			Integer prodQty = memberCart.get(prodNo);
			ShoppingCartItem item = new ShoppingCartItem.Builder()
														.setProdNo(prodNo)
														.setProdName(vo.getProdName())
														.setProdPrice(vo.getProdPrice())
														.setProdQty(prodQty)
														.build();
			Integer restaurantNo = vo.getRestaurantNo();
			if (result.containsKey(restaurantNo)) {
				Set<ShoppingCartItem> temp = result.get(restaurantNo).getCart();
				temp.add(item);
				result.get(restaurantNo).setCart(temp);
			} else {
				ShoppingCartWrapper wrapper = new ShoppingCartWrapper();
				wrapper.setRestaurantNo(restaurantNo);
				wrapper.setRestaurantName(vo.getRestaurantName());
				Set<ShoppingCartItem> temp = wrapper.getCart();
				temp.add(item);
				wrapper.setCart(temp);
				result.put(restaurantNo, wrapper);
			}
		}
//		Set<ShoppingCartWrapper> result = new HashSet<>();
//		System.out.println(result);
//		System.out.println(result.values());
		return result.values();
	}
}
