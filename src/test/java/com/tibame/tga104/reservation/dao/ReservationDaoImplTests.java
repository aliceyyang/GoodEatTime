package com.tibame.tga104.reservation.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.reservation.vo.ReservationVO;



@SpringBootTest
public class ReservationDaoImplTests {
	
	@Autowired
	private ReservationDao dao;

	@Test
	public void reservationDaoTest() {

		//	select
		List<ReservationVO> vo = dao.getAll();
		System.out.println("bean="+ vo);
		
		// insert
//		ReservationVO insert = new ReservationVO();
//		insert.setReserveNum(22);
//		insert.setReserveTime("17:00");
//		insert.setReserveDate(new java.sql.Date(new GregorianCalendar(2022, 12, 22).getTimeInMillis()));
//		insert.setMemberNo(5);
//		insert.setReserveStatus("訂位成功");
//		insert.setRestaurantNo(2);
//		insert.setRemark(null);
//		insert.setCommentContent(null);
//		insert.setCommentRating(null);
//		insert.setCommentPic(null);
//		insert.setRestaurantRe(null);
//		
//		ReservationVO result1 = dao.insert(insert);
//		System.out.println(result1);
		
		// update
//		boolean update = dao.update(2, "報告成功", 5, "餐很好吃",null,  new java.sql.Timestamp(new GregorianCalendar(2022, 12, 21).getTimeInMillis()), null, null);
//		System.out.println("update="+update);
		
	}

}
