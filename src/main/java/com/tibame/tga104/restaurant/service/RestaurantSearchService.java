package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;

public interface RestaurantSearchService {
	
	public List<RestaurantSearchVO> getAll();
	
	public List<RestaurantSearchVO> selectByrestaurantName(String restaurantName);
	
	public List<RestaurantSearchVO> selectNewrestaurant();
 }
