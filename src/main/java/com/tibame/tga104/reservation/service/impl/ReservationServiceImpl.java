package com.tibame.tga104.reservation.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.reservation.dao.impl.ReservationDaoImpl;
import com.tibame.tga104.reservation.service.ReservationService;
import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReservationDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;
import com.tibame.tga104.reservation.vo.RestaurantReservationInfVO;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDaoImpl dao;

	@Override
	public ReservationVO bookTable(ReservationVO reservationVO) {
		ReservationVO result = null;
		if (new MemberVO().getMemberNo() != null) {
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

	@Override
	public List<MemberReserveInfVO> findByMemberNO(Integer memberNo) {
		return dao.findByMemeberNo(memberNo);
	}

	@Override
	public List<ReservationDetailVO> findByRestaurantNoAndDate(Integer restaurantNo, java.sql.Date date) {
		if (date != null && restaurantNo != null) {
			return dao.findByRestaurantNoAndDate(restaurantNo, date);
		}
		return null;
	}

	@Override
	public List<RestaurantReservationInfVO> findByReserveDate(Integer restaurantNo, Date date) {
		if(date != null && restaurantNo != null) {
			return dao.findbyResveDate(restaurantNo, date);
		}
		return null;
	}

	@Override
	public boolean changeStatus(ReservationVO vo) {
		if(vo.getReserveNo() != null) {
			return dao.updateStatus(vo.getReserveNo(), vo.getReserveStatus());
		}
		return false;
	}
	
	@Override
	public List<ReservationVO> selectNotNullComment() {
		return dao.getNotNullComment();
	}
	
	@Override
	public List<ReservationVO> selectNullComment(){
		return dao.getNullComment();
	}
	
	@Override
	public ReservationVO updateRestaurantComment(ReservationVO reservationVO){
		return dao.updateCommnet(reservationVO);
		
	}
=======

	@Override
	public boolean reservation(ReservationVO reservationVO) {
		if(reservationVO != null) {
			dao.insert(reservationVO);
			return true;
		}
		return false;
	}
	
	
	
>>>>>>> Cindy
}
