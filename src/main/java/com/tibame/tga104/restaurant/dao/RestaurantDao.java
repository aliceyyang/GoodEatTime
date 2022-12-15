package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantVO;

public interface RestaurantDao {

	public boolean insert(RestaurantVO restaurantVO);

	public boolean update(RestaurantVO restaurantVO);

	public void setStatus(Integer restaurantNo,Boolean restaurantStatus);

	public RestaurantVO findByPrimaryKey(Integer restaurantNo);

	public List<RestaurantVO> getAll();

}
