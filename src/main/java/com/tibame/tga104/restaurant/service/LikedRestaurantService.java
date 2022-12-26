package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;

public interface LikedRestaurantService {
	
	boolean addLikedRestaurant(LikedRestaurantVO likedRestaurantVO);
	
	void deleteLikedRestaurant(LikedRestaurantVO likedRestaurantVO);
	
	List<LikedRestaurantVO> getListLikedRestaurant(Integer memberNo);

}
