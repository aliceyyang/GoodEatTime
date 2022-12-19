package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantVO;
import org.springframework.stereotype.Component;

@Component
public interface RestaurantService {
	
	
	boolean addRestaurant(RestaurantVO restaurantVO);
	
	RestaurantVO updateRestaurant(String restaurantTel,String restaurantName,String restaurantTaxIDNo,String restaurantAccountInfo,String restaurantBusinessHour,String restaurantAddr,
			String restaurantAccount,String restaurantPassword,Integer restaurantNO);

	void setStatus(Integer restaurantNo,Boolean restaurantStatus);
	
	List<RestaurantVO> getAll();
	
	RestaurantVO getOneRestaurant(Integer restaurantNo);

	List<RestaurantVO> getAccountByAll(); // written by Alice
}
