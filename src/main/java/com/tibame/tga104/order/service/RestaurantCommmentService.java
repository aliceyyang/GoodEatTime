package com.tibame.tga104.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.RestaurantCommentDAO_Hibernate;
import com.tibame.tga104.reservation.dao.impl.ReservationDaoImpl;
import com.tibame.tga104.reservation.vo.ReservationVO;

@Service
@Transactional
public class RestaurantCommmentService {

	@Autowired
	private RestaurantCommentDAO_Hibernate dao;
	
	public List<ReservationVO> selectNotNullComment() {
		return dao.getNotNullComment();
	}
	
	public List<ReservationVO> selectNullComment(){
		return dao.getNullComment();
	}
	
	public ReservationVO updateRestaurantComment(ReservationVO reservationVO){
		return dao.updateCommnet(reservationVO);
		
	}
}
