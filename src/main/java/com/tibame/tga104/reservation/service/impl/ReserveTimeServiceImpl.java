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
	public boolean setReserveTime(Integer restaurantNo, List<ReserveTimeVO> list) {
		for (ReserveTimeVO vo : list) {
			vo.setRestaurantNo(restaurantNo);
			List<ReserveTimeVO> reserveList = dao.findByRestaurantNOandWeekDay(vo.getRestaurantNo(), vo.getWeekDay());
			if (reserveList == null || reserveList.isEmpty()) {
				dao.insert(vo);
			} else {
				dao.update(vo);
			}
		}
		return true;
	}

//	@Override
//	public boolean updatePeople(Integer restaurantNO, List<ReserveTimeVO> list) {
//		for (ReserveTimeVO vo : list){
//			if (dao.findbyrestaurantNOandWeekDay(vo.getRestaurantNo(), vo.getWeekDay()) != null)
//				vo.setRestaurantNo(restaurantNO);
//				dao.updateAllowReserveNum(vo);
//		}
//		return true;
//	}
	
	@Override
	public boolean updatePeople(Integer restaurantNO, List<ReserveTimeVO> list) {
		for (ReserveTimeVO vo : list){
			if(vo != null) {
				vo.setRestaurantNo(restaurantNO);
				dao.update(vo);
			}
		}
		return true;
	}

	@Override
	public List<Integer> findByRestaurantNo(Integer restaurantNo) {
		return dao.findByRestaurantNo(restaurantNo);
	}

	@Override
	public List<ReserveTimeVO> getAll() {
		return dao.getAll();
	}

	@Override
	public List<ReserveTimeVO> findByWeekDay(Integer restaurantNO, Integer weekDay) {
		if (restaurantNO != null && weekDay != null) {
			return dao.findByRestaurantNOandWeekDay(restaurantNO, weekDay);
		}
		return null;
	}

}
