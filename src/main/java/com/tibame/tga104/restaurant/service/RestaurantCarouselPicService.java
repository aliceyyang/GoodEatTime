package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;


public interface RestaurantCarouselPicService {

	boolean addRestaurantCarouselPic(RestaurantCarouselPicVO restaurantCarouselPicVO);
	
	boolean updateRestaurantCarouselPic(RestaurantCarouselPicVO restaurantCarouselPicVO);
	
	boolean deleteRestaurantCarouselPic(Integer carouselPicNo);
	
	List<RestaurantCarouselPicVO> findByRestaurantNo(Integer restaurantNo);
}
