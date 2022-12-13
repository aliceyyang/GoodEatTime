package com.tibame.tga104.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.reservation.dao.ReserveTimeDao;
import com.tibame.tga104.reservation.service.ReserveTimeService;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@Service
@Transactional
public class ReserveTimeServiceImpl implements ReserveTimeService {
	
	@Autowired
	private ReserveTimeDao dao;

	@Override
	public boolean setReserveTime(List<ReserveTimeVO> list) {
		for (ReserveTimeVO vo :list) {
			dao.insert(vo);
		}
		return true;
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
