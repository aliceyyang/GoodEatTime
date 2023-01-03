package com.tibame.tga104.order.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.RestCommentReply_Hibernate;
import com.tibame.tga104.order.dao.RestaurantCommentDAO_Hibernate;
import com.tibame.tga104.order.vo.ProdCommentReplyVO;
import com.tibame.tga104.order.vo.RestCommentReplyVO;
import com.tibame.tga104.reservation.vo.ReservationVO;

@Service
@Transactional
public class RestaurantCommmentService {

	@Autowired
	private RestaurantCommentDAO_Hibernate dao;
	
	@Autowired
	private RestCommentReply_Hibernate dao_H;
	
	public ReservationVO select(Integer reserveNo, Integer restaurantNo) {
		if(reserveNo == null || restaurantNo == null || reserveNo < 0 || restaurantNo < 0) {
			return null;
		}
		return dao.select(reserveNo, restaurantNo);
	}
	
	public List<RestCommentReplyVO> selectNotNullComment(RestCommentReplyVO restCommentReplyVO) {
		return dao_H.getNotNullComment(restCommentReplyVO);
	}
	
	public List<RestCommentReplyVO> selectNullComment(){
		return dao_H.getNullComment();
	}
	
	public List<RestCommentReplyVO> selectForMemberNotNullComment(RestCommentReplyVO restCommentReplyVO) {
		return dao_H.getForMemberNotNullComment(restCommentReplyVO);
	}
	
	public List<RestCommentReplyVO> selectForMemberNullComment(RestCommentReplyVO restCommentReplyVO) {
		return dao_H.getForMemberNullComment(restCommentReplyVO);
	}
	
	public ReservationVO updateRestaurantComment(ReservationVO reservationVO){
		if (reservationVO.getCommentPic() == null && reservationVO.getCommentPicStr() != null) {
			reservationVO.setCommentPic(Base64.getDecoder().decode(reservationVO.getCommentPicStr()));
		}
		return dao.updateCommnet(reservationVO);
	}
	public ReservationVO replyRestaurantComment(ReservationVO reservationVO) {
		return dao.replyComment(reservationVO);
	}
}
