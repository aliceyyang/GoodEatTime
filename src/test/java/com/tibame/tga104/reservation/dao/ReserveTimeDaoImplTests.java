package com.tibame.tga104.reservation.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.common.connection.HibernateUtil;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@SpringBootTest
public class ReserveTimeDaoImplTests {

	@Autowired
	private ReserveTimeDao dao;

	@Test
	public void reserveTimeDaoTest() {

		// select
//		List<ReserveTimeVO> vo = dao.getAll();
//		System.out.println("bean="+ vo);

		// select findbyrestaurantNo
//		List<ReserveTimeVO> vo =  dao.findbyrestaurantNo(1);
//		System.out.println("bean=" + vo);

		// select findbyrestaurantNoandWeekDay
		List<ReserveTimeVO> vo = dao.findbyrestaurantNOandWeekDay(1, 0);
		System.out.println("bean=" + vo);

		// insert
//		ReserveTimeVO insert = new ReserveTimeVO();
//		insert.setRestaurantNo(5);
//		insert.setReserveTime("17:00");
//		insert.setWeekDay(0);;
//		insert.setAllowReserveNum(31);
//
//		ReserveTimeVO result1 = dao.insert(insert);
//		System.out.println(result1);

		// update
//		boolean update = dao.updateAllowReserveNum(122, "17:00", 22);
//		System.out.println("update="+update);

//		boolean update = dao.updateWeekDay(76, "17:00", 2, 22);
//		System.out.println("update="+update);
//		
//		ReserveTimeVO update = new ReserveTimeVO();
//		update.setReserveTimeNo(119);
//		update.setRestaurantNo(5);
//		update.setReserveTime("17:00");
//		update.setWeekDay(0);;
//		update.setAllowReserveNum(32);
//		
//		ReserveTimeVO result1 = dao.update(update);
//		System.out.println(result1);

	}

}
