package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.RestaurantVO;

public interface RestaurantDao {

	public void insert(RestaurantVO restaurantVO);

	public void update(RestaurantVO restaurantVO);

	public void setStatus(Integer restaurantNo,Boolean restaurantStatus);

	public RestaurantVO findByPrimaryKey(Integer restaurantNo);

	public List<RestaurantVO> getAll();

}
