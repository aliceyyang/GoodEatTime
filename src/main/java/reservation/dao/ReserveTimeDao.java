package reservation.dao;

import java.util.List;

import reservation.vo.ReserveTimeVO;

public interface ReserveTimeDao {
	public ReserveTimeVO insert(ReserveTimeVO reserveTimeVo);

	public boolean updateAllowReserveNum(Integer reserveTimeNO, String reserveTime, Integer allowReserveNum);

	public boolean updateWeekDay(Integer reserveTimeNO, String reserveTime, Integer weekDay, Integer allowReserveNum);

	public ReserveTimeVO update(ReserveTimeVO reserveTimeVO);

	public List<ReserveTimeVO> findbyrestaurantNOandWeekDay(Integer restaurantNo, Integer weekDay);

	public List<ReserveTimeVO> findbyrestaurantNo(Integer restaurantNo);

	public List<ReserveTimeVO> getAll();

}
