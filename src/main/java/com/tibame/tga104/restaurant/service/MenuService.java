package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.MenuVO;

public interface MenuService {
	
	boolean addMenu(MenuVO menuVO);
	
	boolean updateMenu(MenuVO menuVO);
	
	boolean deleteMenu(Integer MenuNo);
	
	List<MenuVO> findByRestaurantNo(Integer restaurantNo);

}
