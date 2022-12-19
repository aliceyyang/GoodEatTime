package com.tibame.tga104.product.dao;

import java.util.List;
import java.util.Map;

import com.tibame.tga104.product.vo.ShoppingCartVO;

public interface ShoppingCartDAO {
	public ShoppingCartVO insert(ShoppingCartVO shoppingCartVO);
	public ShoppingCartVO update(ShoppingCartVO shoppingCartVO);
	public boolean delete(Integer memberNo, Integer prodNo);
	public ShoppingCartVO findByPrimaryKey(Integer memberNo, Integer prodNo);
	public List<ShoppingCartVO> getAll();
	//改用redis，此方法改成回傳Map型別資料
//	public List<ShoppingCartVO> findByMemberNo(Integer memberNo);
	public Map<Integer, Integer> findByMemberNo(Integer memberNo);
	public Integer getSumByMemberNo(Integer memberNo);
}
