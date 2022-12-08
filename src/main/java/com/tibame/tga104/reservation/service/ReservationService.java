package com.tibame.tga104.reservation.service;

import java.util.List;

import com.tibame.tga104.reservation.vo.ReservationVO;

public interface ReservationService {
		
	ReservationVO bookTable(ReservationVO reservationVO);
	
	List<ReservationVO> findByDate(java.sql.Date reserveDate);
	
	List<ReservationVO> getAll();

}
