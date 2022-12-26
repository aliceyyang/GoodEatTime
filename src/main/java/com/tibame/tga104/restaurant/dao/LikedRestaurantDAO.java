package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;

public interface LikedRestaurantDAO {
	
	public boolean insert(LikedRestaurantVO likedRestaurantVO);

	public boolean delete(LikedRestaurantVO likedRestaurantVO);

	public List<LikedRestaurantVO> findByMemberNo(Integer memberNo);

}
