package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;

public interface RestaurantSearchDAO {

	public List<RestaurantSearchVO> getAll();
	
	public List<RestaurantSearchVO> selectByrestaurantName(String restaurantNo);
}
