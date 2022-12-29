package com.tibame.tga104.restaurant.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.restaurant.service.ReservationCommentService;
import com.tibame.tga104.restaurant.vo.ReservationCommentVO;

@RestController
public class ReservationCommentController {
	
	@Autowired
	private ReservationCommentService service;
	
	//透過餐廳編號查詢每個星等的數量
	@GetMapping("/restaurant-rating/{restaurantNo}")
	public List<Integer> getAllRating(@PathVariable Integer restaurantNo){
		return service.getAllRating(restaurantNo);
	}
	
	//透過餐廳編號查詢所有評論
	@GetMapping("/restaurant-comment/{restaurantNo}")
	public List<ReservationCommentVO> getAllComment(@PathVariable Integer restaurantNo){
		
		List<ReservationCommentVO> list = service.findByRestaurantNo(restaurantNo);
		
		for(ReservationCommentVO vo : list) {
			if(vo.getMemberPic() != null) {
				String memberPicStr = Base64.getEncoder().encodeToString(vo.getMemberPic());
				vo.setMemberPicStr(memberPicStr);
			}
			if(vo.getCommentPic() != null) {
				String CommentPicStr = Base64.getEncoder().encodeToString(vo.getCommentPic());
				vo.setCommentPicStr(CommentPicStr);
			}
		}
		return list;
	}

}
