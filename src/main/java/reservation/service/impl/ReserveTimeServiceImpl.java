package reservation.service.impl;

import java.util.List;

import javax.naming.NamingException;

import reservation.dao.ReserveTimeDao;
import reservation.dao.impl.ReserveTimeDaoImpl;
import reservation.service.ReserveTimeService;
import reservation.vo.ReserveTimeVO;

public class ReserveTimeServiceImpl implements ReserveTimeService {

	private ReserveTimeDao dao;

	public ReserveTimeServiceImpl() throws NamingException {
		dao = new ReserveTimeDaoImpl();
	}

	@Override
	public ReserveTimeVO setReserveTime(String reserveTime, Integer weekDay, Integer allowReserveNum) {
		ReserveTimeVO vo = new ReserveTimeVO();
		vo.setWeekDay(weekDay);
		if (weekDay != null) {
			if (weekDay < 7 || weekDay >= 0) {
				vo.setAllowReserveNum(allowReserveNum);
				vo.setReserveTime(reserveTime);
				dao.insert(vo);
			}
		}
		return vo;
	}

	@Override
	public ReserveTimeVO updatePeople(Integer restaurantNO, String reserveTime, Integer weekDay, Integer allowReserveNum) {
		ReserveTimeVO vo = dao.findbyrestaurantNOandWeekDay(restaurantNO, weekDay);
		if(vo != null) {
			if(weekDay != null){
				vo.setReserveTime(reserveTime);
				vo.setAllowReserveNum(allowReserveNum);
				dao.updateAllowReserveNum(vo);
			}
		}
		return vo;
	}

	@Override
	public ReserveTimeVO businessDay(Integer restaurantNo, Integer weekDay) {
		ReserveTimeVO vo = dao.findbyrestaurantNOandWeekDay(restaurantNo, weekDay);
		if(vo != null) {
			vo.setWeekDay(weekDay);
			dao.updateWeekDay(vo);
		}
		return vo;
	}


	@Override
	public List<ReserveTimeVO> getAll() {
		return dao.getAll();
	}

	@Override
	public ReserveTimeVO findByWeekDay(Integer restaurantNO, Integer weekDay) {
		return dao.findbyrestaurantNOandWeekDay(restaurantNO, weekDay);
	}

}
