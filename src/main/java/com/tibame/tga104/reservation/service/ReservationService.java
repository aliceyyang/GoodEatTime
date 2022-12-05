package com.tibame.tga104.reservation.service;

import java.util.List;

import com.tibame.tga104.reservation.vo.ReservationVO;

public interface ReservationService {
		
	ReservationVO BookTable(ReservationVO reservationVO);
	
	boolean CommentRestaurant(Integer reserveNo, Integer memberNo, Integer commentRating, String commentContent, byte[] commentPic, java.sql.Timestamp restaurantCommentTime);
	
	boolean RestaurantReply(Integer reserveNo, Integer commentRating, String restaurantRe, java.sql.Timestamp restaurantReTime);
	
	ReservationVO findByDate(Integer reserveDate);
	
	List<ReservationVO> getAll();

}
