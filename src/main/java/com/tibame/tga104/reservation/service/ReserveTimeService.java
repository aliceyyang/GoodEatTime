
package com.tibame.tga104.reservation.service;

import java.util.List;

import com.tibame.tga104.reservation.vo.ReserveTimeVO;

public interface ReserveTimeService {
	// 設定訂位人數及營業時間
	boolean setReserveTime(List<ReserveTimeVO> list);

	// 更新訂位人數
	boolean updatePeople(Integer reserveTimeNO, Integer restaurantNO, String reserveTime, Integer WeekDay,
			Integer allowReserveNum);

	List<ReserveTimeVO> businessDay(Integer reserveTimeNO, Integer restaurantNo, String reserveTime, Integer weekDay,
			Integer allowReserveNum);

	List<ReserveTimeVO> findByWeekDay(Integer restaurantNO, Integer weekDay);

	List<ReserveTimeVO> getAll();

}
