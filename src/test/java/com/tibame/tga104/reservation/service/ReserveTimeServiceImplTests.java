package com.tibame.tga104.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@SpringBootTest
public class ReserveTimeServiceImplTests {
	
	@Autowired
	private ReserveTimeService reserveTimeService;
	
//	@Test
//	public void setReserveTime() {
//		List<ReserveTimeVO> list = new ArrayList();
//		ReserveTimeVO vo = new ReserveTimeVO();
//		vo.setAllowReserveNum(11);
//		vo.setReserveTime("12:00");
//		vo.setRestaurantNo(2);
//		vo.setWeekDay(0);
//		list.add(vo);
//		boolean set = reserveTimeService.setReserveTime(list);
//		System.out.println("set="+ set);	
//	}
	
//	@Test
//	public void selectAll() {
//		List<ReserveTimeVO> selects = reserveTimeService.getAll();
//		System.out.println("selects="+selects);
//	}
	
//	@Test
//	public void selectWeekDay() {
//		List<ReserveTimeVO> selects = reserveTimeService.findByWeekDay(2, 1);
//		System.out.println("selects="+selects);
//	}

	
//	@Test
//	public void businessDay() {
//		List<ReserveTimeVO> selects = reserveTimeService.businessDay(1, 2, "12:00", 0, 25);
//		System.out.println("selects="+selects);
//		
//	}
	
//	@Test
//	public void updatePeople() {
//		boolean result = reserveTimeService.updatePeople(1, 2, "12:00", 0, 25);
//		System.out.println("selects="+ result);
//		
//	}
}
