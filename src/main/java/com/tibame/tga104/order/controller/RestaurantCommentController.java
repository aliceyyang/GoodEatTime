package com.tibame.tga104.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.order.service.RestaurantCommmentService;
import com.tibame.tga104.order.vo.ProdCommentReplyVO;
import com.tibame.tga104.order.vo.RestCommentReplyVO;
import com.tibame.tga104.reservation.vo.ReservationVO;

@RestController
@RequestMapping("restaurantcomment")
public class RestaurantCommentController {
	
	@Autowired
	private RestaurantCommmentService restaurantCommmentService;
	
	@PostMapping("NotNullComment")
	public List<RestCommentReplyVO> NotNullComment(@RequestBody RestCommentReplyVO restCommentReplyVO){
//		System.out.println(restCommentReplyVO);
		return restaurantCommmentService.selectNotNullComment(restCommentReplyVO);
	}
	
	@PostMapping("NullComment")
	public List<RestCommentReplyVO> NullComment(){
		return restaurantCommmentService.selectNullComment();
	}
	
	@PostMapping("ForMemberNotNullComment")
	public List<RestCommentReplyVO> forMemberNotNullComment(@RequestBody RestCommentReplyVO restCommentReplyVO){
		return restaurantCommmentService.selectForMemberNotNullComment(restCommentReplyVO);
	}
	
	@PostMapping("ForMemberNullComment")
	public List<RestCommentReplyVO> forMemberNullComment(@RequestBody RestCommentReplyVO restCommentReplyVO){
		System.out.println(restaurantCommmentService.selectForMemberNullComment(restCommentReplyVO));
		return restaurantCommmentService.selectForMemberNullComment(restCommentReplyVO);
	}
		
	@PostMapping("Commnet")
	public ReservationVO restaurantCommnet (@RequestBody(required = false) ReservationVO reservationVO) {
		return restaurantCommmentService.updateRestaurantComment(reservationVO);
	}
	@PostMapping("CommnetReply")
	public ReservationVO restaurantCommnetReply (@RequestBody(required = false) ReservationVO reservationVO) {
		return restaurantCommmentService.replyRestaurantComment(reservationVO);
	}
	
	@GetMapping("ShowCommentPic")
	public byte[] showCommentPic(@RequestParam Integer reserveNo, @RequestParam Integer restaurantNo) {
		return restaurantCommmentService
				.select(reserveNo, restaurantNo)
				.getCommentPic();
	}
}
