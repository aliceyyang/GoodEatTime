package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantPicVO;

public interface RestaurantPicDAO {
	
	public boolean insert(RestaurantPicVO restaurantPicVO);

	public boolean update(RestaurantPicVO restaurantPicVO);

	public boolean delete(Integer restaurantPicNo);

	public RestaurantPicVO findByPrimaryKey(Integer restaurantPicNo);

	public List<RestaurantPicVO> findByRestaurantNo(Integer restaurantNo);


}
