
package com.tibame.tga104.reservation.service;

import java.util.List;

import com.tibame.tga104.reservation.vo.ReserveTimeVO;

public interface ReserveTimeService {
	// 設定訂位人數及營業時間
	boolean setReserveTime(Integer restaurantNo, List<ReserveTimeVO> list);

	// 更新訂位人數
	boolean updatePeople(Integer restaurantNO, List<ReserveTimeVO> list);

	List<Integer> findByRestaurantNo(Integer restaurantNo);

	List<ReserveTimeVO> findByWeekDay(Integer restaurantNO, Integer weekDay);

	List<ReserveTimeVO> getAll();

}
