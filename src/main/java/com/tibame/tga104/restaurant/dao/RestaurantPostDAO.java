package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantPostVO;

public interface RestaurantPostDAO {
	
public boolean insert(RestaurantPostVO restaurantPostVO);
	
	public boolean update(RestaurantPostVO restaurantPostVO);
	
	public boolean delete(Integer restaurantPostNo);
	
	public List<RestaurantPostVO> findByRestaurantNo(Integer restaurantNo);

}
