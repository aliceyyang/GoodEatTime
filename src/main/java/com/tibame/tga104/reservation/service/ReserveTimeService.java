
package com.tibame.tga104.reservation.service;

import java.util.List;

import com.tibame.tga104.reservation.vo.ReserveTimeVO;

public interface ReserveTimeService {
	ReserveTimeVO setReserveTime(ReserveTimeVO reserveTimeVO);

	boolean updatePeople(Integer reserveTimeNO, Integer restaurantNO, String reserveTime, Integer WeekDay,
			Integer allowReserveNum);

	List<ReserveTimeVO> businessDay(Integer reserveTimeNO, Integer restaurantNo, String reserveTime, Integer weekDay,
			Integer allowReserveNum);

	List<ReserveTimeVO> findByWeekDay(Integer restaurantNO, Integer weekDay);

	List<ReserveTimeVO> getAll();

}
