package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantPostVO;

public interface RestaurantPostService {
	
	boolean addRestaurantPost(RestaurantPostVO restaurantPostVO);
	
	boolean updateRestaurantPost(RestaurantPostVO restaurantPostVO);
	
	boolean deleteRestaurantPost(Integer restaurantPostNo);
	
	List<RestaurantPostVO> findByRestaurantNo(Integer restaurantNo);
}
