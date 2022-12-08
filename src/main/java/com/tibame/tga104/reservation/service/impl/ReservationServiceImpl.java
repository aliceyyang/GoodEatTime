package com.tibame.tga104.reservation.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.reservation.dao.impl.ReservationDaoImpl;
import com.tibame.tga104.reservation.service.ReservationService;
import com.tibame.tga104.reservation.vo.ReservationVO;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationDaoImpl dao;
	
	@Override
	public ReservationVO bookTable(ReservationVO reservationVO) {
		ReservationVO result = null;
		if (new RestaurantVO().getRestaurantNo() != null && new MemberVO().getMemberNo() != null) {
			result = dao.insert(reservationVO);
		}
		return result;
	}


	@Override
	public List<ReservationVO> findByDate(java.sql.Date reserveDate) {
		return dao.findByReserveDate(reserveDate);
	}

	@Override
	public List<ReservationVO> getAll() {
		return dao.getAll();
	}

}
