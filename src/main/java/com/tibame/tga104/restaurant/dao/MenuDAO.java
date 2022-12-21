package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.MenuVO;


public interface MenuDAO {
	
	public boolean insert(MenuVO menuVO);
	
	public boolean update(MenuVO menuVO);
	
	public boolean delete(Integer menuNo);
	
	public List<MenuVO> findByRestaurantNo(Integer restaurantNo);

}
