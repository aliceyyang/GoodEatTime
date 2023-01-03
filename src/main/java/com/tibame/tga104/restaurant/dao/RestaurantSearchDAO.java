package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

public interface RestaurantSearchDAO {

	public List<RestaurantSearchVO> getAll();
	
	public List<RestaurantSearchVO> selectByrestaurantName(String restaurantName);
	
	public List<RestaurantSearchVO> selectByrestaurantNo (Integer restaurantNo);
}
