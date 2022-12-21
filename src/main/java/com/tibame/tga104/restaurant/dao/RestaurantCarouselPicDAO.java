package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;

public interface RestaurantCarouselPicDAO {
	
	public boolean insert(RestaurantCarouselPicVO restaurantCarouselPicVO);
	
	public boolean delete(Integer carouselPicNo);
	
	public List<RestaurantCarouselPicVO> findByRestaurantNo(Integer restaurantNo);

}
