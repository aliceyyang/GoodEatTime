package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.RestaurantPostDAO;
import com.tibame.tga104.restaurant.service.RestaurantPostService;
import com.tibame.tga104.restaurant.vo.RestaurantPostVO;

@Component
public class RestaurantPostServiceImpl implements RestaurantPostService{
	
	@Autowired
	private RestaurantPostDAO dao;
	

	@Override
	public boolean addRestaurantPost(RestaurantPostVO restaurantPostVO) {
		return dao.insert(restaurantPostVO);
	}

	@Override
	public boolean updateRestaurantPost(RestaurantPostVO restaurantPostVO) {
		return dao.update(restaurantPostVO);
	}

	@Override
	public boolean deleteRestaurantPost(Integer restaurantPostNo) {
		return dao.delete(restaurantPostNo);
	}

	@Override
	public List<RestaurantPostVO> findByRestaurantNo(Integer restaurantNo) {
		return dao.findByRestaurantNo(restaurantNo);
	}

}
