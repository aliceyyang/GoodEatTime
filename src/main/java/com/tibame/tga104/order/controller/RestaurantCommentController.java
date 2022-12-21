package com.tibame.tga104.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.order.service.RestaurantCommmentService;
import com.tibame.tga104.reservation.vo.ReservationVO;

@RestController
@RequestMapping("restaurantcomment")
public class RestaurantCommentController {
	
	@Autowired
	private RestaurantCommmentService restaurantCommmentService;
	
	@PostMapping("NotNullComment")
	public List<ReservationVO> NotNullComment(){
		return restaurantCommmentService.selectNotNullComment();
	}
	
	@PostMapping("NullComment")
	public List<ReservationVO> NullComment(){
		return restaurantCommmentService.selectNullComment();
	}
		
	@PostMapping("Commnet")
	public ReservationVO restaurantCommnet (@RequestBody(required = false) ReservationVO reservationVO) {
		return restaurantCommmentService.updateRestaurantComment(reservationVO);
	}
}
