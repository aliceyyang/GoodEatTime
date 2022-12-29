package com.tibame.tga104.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.ReservationCommentDAO;
import com.tibame.tga104.restaurant.service.ReservationCommentService;
import com.tibame.tga104.restaurant.vo.ReservationCommentVO;

@Component 
public class ReservationCommentServiceImpl implements ReservationCommentService{
	
	@Autowired
	private ReservationCommentDAO dao;
	
	@Override
	public List<Integer> getAllRating(Integer restaurantNo) {
		return dao.getAllRating(restaurantNo);
	}

	@Override
	public List<ReservationCommentVO> findByRestaurantNo(Integer restaurantNo) {
		return dao.findByRestaurantNo(restaurantNo);
	}

}
