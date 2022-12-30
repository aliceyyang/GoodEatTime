package com.tibame.tga104.order.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.RestaurantCommentDAO_Hibernate;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;

@Service
@Transactional
public class RestaurantCommmentService {

	@Autowired
	private RestaurantCommentDAO_Hibernate dao;
	
	public ReservationVO select(Integer reserveNo, Integer restaurantNo) {
		if(reserveNo == null || restaurantNo == null || reserveNo < 0 || restaurantNo < 0) {
			return null;
		}
		return dao.select(reserveNo, restaurantNo);
	}
	
	public List<ReservationVO> selectNotNullComment() {
		return dao.getNotNullComment();
	}
	
	public List<ReservationVO> selectNullComment(){
		return dao.getNullComment();
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
