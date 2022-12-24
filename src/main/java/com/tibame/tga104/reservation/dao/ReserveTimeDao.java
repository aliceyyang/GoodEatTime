package com.tibame.tga104.reservation.dao;

import java.sql.Date;
import java.util.List;

import com.tibame.tga104.reservation.vo.ReservationDetailVO;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

public interface ReserveTimeDao {
	public ReserveTimeVO insert(ReserveTimeVO reserveTimeVo);

	public ReserveTimeVO updateAllowReserveNum(ReserveTimeVO reserveTimeVo);

	public ReserveTimeVO updateWeekDay(ReserveTimeVO reserveTimeVo);

	public int update(ReserveTimeVO reserveTimeVO);

	public List<ReserveTimeVO> findByRestaurantNOandWeekDay(Integer restaurantNo, Integer weekDay);

	public List<Integer> findByRestaurantNo(Integer restaurantNo);
	
	public List<Integer> getReserveTimeNo(Integer restaurantNo, Integer weekDay);

	public List<ReserveTimeVO> getAll();

	public Integer getSeats(Integer restaurantNo, java.sql.Date reserveDate, String reserveTime);

	public Integer getSeats(Integer restaurantNo, String reserveTime, Integer weekDay);
	
	public List<java.util.Date> getDate(Integer restaurantNo, String reserveTime);
}
