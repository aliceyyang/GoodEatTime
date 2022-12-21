package com.tibame.tga104.reservation.service;

import java.util.List;

import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReservationDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;
import com.tibame.tga104.reservation.vo.RestaurantReservationInfVO;

public interface ReservationService {
		
	ReservationVO bookTable(ReservationVO reservationVO);
	
	List<ReservationVO> findByDate(java.sql.Date reserveDate);
	
	List<ReservationVO> getAll();
	
	List<MemberReserveInfVO> findByMemberNO(Integer memberNo);
	
	List<ReservationDetailVO> findByRestaurantNoAndDate(Integer restaurantNo, java.sql.Date date);
	
	List<RestaurantReservationInfVO> findByReserveDate(Integer restaurantNo, java.sql.Date date);
	
	boolean changeStatus(ReservationVO vo);
	
	boolean reservation(ReservationVO reservationVO);
	
}
