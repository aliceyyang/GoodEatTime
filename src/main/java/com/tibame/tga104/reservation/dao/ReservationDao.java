package com.tibame.tga104.reservation.dao;

import java.util.List;

import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReservationDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;
import com.tibame.tga104.reservation.vo.RestaurantReservationInfVO;


public interface ReservationDao {
	public ReservationVO insert(ReservationVO reservationVO);
	
	public boolean update(Integer reserveNo, String reserveStatus, Integer commentRating, String commentContent, byte[] commentPic, java.sql.Timestamp restaurantCommentTime, String restaurantRe, java.sql.Timestamp restaurantReTime);
	
	public boolean updateStatus(Integer reserveNo, String reserveStatus);
	
	public ReservationVO update(ReservationVO reservationVO);
	
	public ReservationVO findByPrimaryKey(Integer reserveNo);
	
	public List<ReservationVO> findByReserveDate(java.sql.Date reserveDate);
	
	public List<ReservationVO> getAll();

	public List<MemberReserveInfVO> findByMemeberNo(Integer memberNo);
	
	public List<ReservationDetailVO> findByRestaurantNoAndDate(Integer restaurantNo, java.sql.Date reserveDate);
	
	public List<RestaurantReservationInfVO> findbyResveDate(Integer restaurantNo, java.sql.Date reserveDate);
	
	List<ReservationVO> getNotNullComment();

	List<ReservationVO> getNullComment();

	ReservationVO updateCommnet(ReservationVO reservationVO);
}
