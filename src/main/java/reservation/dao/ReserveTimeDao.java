package reservation.dao;

import java.util.List;

import reservation.vo.ReserveTimeVO;

public interface ReserveTimeDao {
	public int insert(ReserveTimeVO reserveTimeVo);
	
	public void updateAllowReserveNum(ReserveTimeVO reserveTimeVo);
	
	public void updateWeekDay(ReserveTimeVO reserveTimeVO);
	
	public ReserveTimeVO findbyrestaurantNOandWeekDay(Integer restaurantNO, Integer weekDay);
	
	public List<ReserveTimeVO> getAll();
	
}
