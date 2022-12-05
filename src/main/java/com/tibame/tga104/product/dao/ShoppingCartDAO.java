package com.tibame.tga104.product.dao;

import java.util.List;

import com.tibame.tga104.product.vo.ShoppingCartVO;

public interface ShoppingCartDAO {
	public ShoppingCartVO insert(ShoppingCartVO shoppingCartVO);
	public ShoppingCartVO update(ShoppingCartVO shoppingCartVO);
	public boolean delete(Integer memberNo, Integer prodNo);
	public ShoppingCartVO findByPrimaryKey(Integer memberNo, Integer prodNo);
	public List<ShoppingCartVO> getAll();
	public List<ShoppingCartVO> findByMemberNo(Integer memberNo);
}
