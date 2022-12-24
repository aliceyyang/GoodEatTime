
package com.tibame.tga104.reservation.service;

import java.util.List;

import com.tibame.tga104.reservation.vo.ReserveTimeVO;

public interface ReserveTimeService {

	boolean setReserveTime(Integer restaurantNo, List<ReserveTimeVO> list);

	boolean updatePeople(Integer restaurantNO, List<ReserveTimeVO> list);

	List<Integer> findByRestaurantNo(Integer restaurantNo);

	List<ReserveTimeVO> findByWeekDay(Integer restaurantNO, Integer weekDay);

	List<ReserveTimeVO> getAll();

	Integer getAvailableSeats(Integer restaurantNo, java.sql.Date reserveDate, String reserveTime);
}
