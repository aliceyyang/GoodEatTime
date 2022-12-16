package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.RestaurantCarouselPicDAO;
import com.tibame.tga104.restaurant.dao.impl.RestaurantCarouselPicDAOImpl;
import com.tibame.tga104.restaurant.service.RestaurantCarouselPicService;
import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;

@Component
public class RestaurantCarouselPicServiceImpl implements RestaurantCarouselPicService {
	
	@Autowired
	private RestaurantCarouselPicDAO dao;
	

	@Override
	public boolean addRestaurantCarouselPic(RestaurantCarouselPicVO restaurantCarouselPicVO) {
		
		return dao.insert(restaurantCarouselPicVO);
	}


	@Override
	public boolean updateRestaurantCarouselPic(RestaurantCarouselPicVO restaurantCarouselPicVO) {
		return dao.update(restaurantCarouselPicVO);
	}


	@Override
	public boolean deleteRestaurantCarouselPic(Integer carouselPicNo) {
		return dao.delete(carouselPicNo);
	}


	@Override
	public List<RestaurantCarouselPicVO> findByRestaurantNo(Integer restaurantNo) {
		return dao.findByRestaurantNo(restaurantNo);
	}

	

	
}
