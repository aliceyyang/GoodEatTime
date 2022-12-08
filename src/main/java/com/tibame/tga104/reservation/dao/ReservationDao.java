package com.tibame.tga104.reservation.dao;

import java.util.List;

import com.tibame.tga104.reservation.vo.ReservationVO;


public interface ReservationDao {
	public ReservationVO insert(ReservationVO reservationVO);
	
	public boolean update(Integer reserveNo, String reserveStatus, Integer commentRating, String commentContent, byte[] commentPic, java.sql.Timestamp restaurantCommentTime, String restaurantRe, java.sql.Timestamp restaurantReTime);
	
	public ReservationVO update(ReservationVO reservationVO);
	
	public ReservationVO findByPrimaryKey(Integer reserveNo);
	
	public List<ReservationVO> findByReserveDate(java.sql.Date reserveDate);
	
	public List<ReservationVO> getAll();

}
