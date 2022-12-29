package com.tibame.tga104.restaurant.service;

import java.util.List;

import com.tibame.tga104.restaurant.vo.ReservationCommentVO;

public interface ReservationCommentService {
	
	List<Integer> getAllRating(Integer restaurantNo);
	
	List<ReservationCommentVO> findByRestaurantNo(Integer restaurantNo);

}
