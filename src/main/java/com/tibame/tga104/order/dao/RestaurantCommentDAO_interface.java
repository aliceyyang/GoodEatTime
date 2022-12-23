package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.ProdOrderDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;

public interface RestaurantCommentDAO_interface {
	
	List<ReservationVO> getNotNullComment();

	List<ReservationVO> getNullComment();

	ReservationVO updateCommnet(ReservationVO reservationVO);
	
	ReservationVO replyComment(ReservationVO reservationVO);

}
