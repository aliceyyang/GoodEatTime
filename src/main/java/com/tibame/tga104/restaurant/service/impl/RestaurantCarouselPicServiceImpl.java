package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.RestaurantCarouselPicDAO;
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
	public boolean deleteRestaurantCarouselPic(Integer carouselPicNo) {
		return dao.delete(carouselPicNo);
	}


	@Override
	public List<RestaurantCarouselPicVO> findByRestaurantNo(Integer restaurantNo) {
		//輪播圖片只取六張圖來使用
		int count = dao.findByRestaurantNo(restaurantNo).size();
		if(count <= 6){
			return dao.findByRestaurantNo(restaurantNo).subList(0, count);
		}
		return dao.findByRestaurantNo(restaurantNo).subList(0, 6);
		
	}

	

	
}
