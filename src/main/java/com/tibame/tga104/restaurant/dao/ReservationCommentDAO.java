package com.tibame.tga104.restaurant.dao;

import java.util.List;

import com.tibame.tga104.restaurant.vo.ReservationCommentVO;

public interface ReservationCommentDAO {
	
	public List<Integer> getAllRating(Integer restaurantNo);
	
	public List<ReservationCommentVO> findByRestaurantNo(Integer restaurantNo);

}
