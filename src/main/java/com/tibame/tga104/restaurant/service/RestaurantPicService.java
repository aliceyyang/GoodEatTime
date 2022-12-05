package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantPicVO;


public interface RestaurantPicService {
	
	RestaurantPicVO addRestaurantPic(Integer restaurantNO,byte[] restaurantPic,String restaurantPicRemark);
	
	RestaurantPicVO updateRestaurantPic(byte[] restaurantPic,String restaurantPicRemark,Integer restaurantPicNo);

	void deleteRestaurantPic(Integer restaurantPicNo);
	
	List<RestaurantPicVO> getRestaurantPic(Integer restaurantNo);
	
	RestaurantPicVO getOneRestaurantPic(Integer restaurantPicNo);

}
