package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.RestaurantSearchDAO;
import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;
@Component
public class RestaurantSearchImpl implements RestaurantSearchDAO{

	@Autowired
	private RestaurantSearchDAO dao;

	@Override
	public List<RestaurantSearchVO> getAll() {
		return dao.getAll();
	}

	@Override
	public List<RestaurantSearchVO> selectByrestaurantName(String restaurantName) {
		if (restaurantName != null && restaurantName.trim().isEmpty()) {
			return dao.selectByrestaurantName(restaurantName);
		}
		return null;
	}
	

}
