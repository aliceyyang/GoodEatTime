package reservation.service.impl;

import java.util.List;

import javax.naming.NamingException;

import reservation.dao.ReserveTimeDao;
import reservation.dao.impl.ReserveTimeDaoImpl;
import reservation.service.ReserveTimeService;
import reservation.vo.ReserveTimeVO;

public class ReserveTimeServiceImpl implements ReserveTimeService {

	private ReserveTimeDao dao;

	@Override
	public ReserveTimeVO setReserveTime(ReserveTimeVO reserveTimeVO) {
		ReserveTimeVO result = null;
		if (reserveTimeVO != null && reserveTimeVO.getRestaurantNo() != null) {
				result = dao.insert(reserveTimeVO);
			}
		return result;
	}

	@Override
	public boolean updatePeople(Integer reserveTimeNO, Integer restaurantNO, String reserveTime, Integer weekDay,
			Integer allowReserveNum) {
		List<ReserveTimeVO> list = dao.findbyrestaurantNOandWeekDay(restaurantNO, weekDay);
		if (list != null) {
			return dao.updateAllowReserveNum(reserveTimeNO, reserveTime, allowReserveNum);
		}
		return false;
	}

	@Override
	public List<ReserveTimeVO> businessDay(Integer reserveTimeNO, Integer restaurantNo, String reserveTime, Integer weekDay,
			Integer allowReserveNum) {
		List<ReserveTimeVO> list = dao.findbyrestaurantNOandWeekDay(restaurantNo, weekDay);
		if (list != null) {
			dao.updateWeekDay(reserveTimeNO, reserveTime, weekDay, allowReserveNum);
		}
		return list;
	}

	@Override
	public List<ReserveTimeVO> getAll() {
		return dao.getAll();
	}

	@Override
	public List<ReserveTimeVO> findByWeekDay(Integer restaurantNO, Integer weekDay) {
		return dao.findbyrestaurantNOandWeekDay(restaurantNO, weekDay);
	}

}
