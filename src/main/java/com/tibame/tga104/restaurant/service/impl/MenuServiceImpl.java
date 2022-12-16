package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.MenuDAO;
import com.tibame.tga104.restaurant.service.MenuService;
import com.tibame.tga104.restaurant.vo.MenuVO;

@Component
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDAO dao;

	@Override
	public boolean addMenu(MenuVO menuVO) {
		return dao.insert(menuVO);
	}

	@Override
	public boolean updateMenu(MenuVO menuVO) {
		return dao.update(menuVO);
	}

	@Override
	public boolean deleteMenu(Integer MenuNo) {
		return dao.delete(MenuNo);
	}

	@Override
	public List<MenuVO> findByRestaurantNo(Integer restaurantNo) {
		return dao.findByRestaurantNo(restaurantNo);
	}

}
