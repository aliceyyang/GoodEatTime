
package reservation.service;

import java.util.List;

import reservation.vo.ReserveTimeVO;

public interface ReserveTimeService {
	ReserveTimeVO setReserveTime(String reserveTime, Integer weekDay, Integer allowReserveNum);
	
	ReserveTimeVO updatePeople(Integer restaurantNO, String reserveTime, Integer WeekDay, Integer allowReserveNum);
	
	ReserveTimeVO businessDay(Integer restaurantNo, Integer weekDay);
		
	ReserveTimeVO findByWeekDay(Integer restaurantNO, Integer weekDay);
	
	List<ReserveTimeVO> getAll();
	
}
