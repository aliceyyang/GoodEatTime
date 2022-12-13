package com.tibame.tga104.reservation.service;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.reservation.vo.ReservationVO;

@SpringBootTest
public class ReservationServiceImplTests {
	@Autowired
	private ReservationService reservationService;
	
//	@Test
//	public void BookTable() {
//		ReservationVO vo = new ReservationVO();
//		vo.setMemberNo(1);
//		vo.setReserveDate(new java.sql.Date(new GregorianCalendar(2022, 12, 22).getTimeInMillis()));
//		vo.setReserveNo(2);
//		vo.setReserveNum(22);
//		vo.setReserveTime("12:00");
//		vo.setRestaurantNo(1);
//		vo.setReserveStatus("訂位成功");
//		vo.setCommentContent(null);
//		vo.setCommentPic(null);
//		vo.setCommentRating(null);
//		vo.setRemark(null);
//		vo.setRestaurantCommentTime(null);
//		vo.setRestaurantRe(null);
//		vo.setRestaurantReTime(null);
//		ReservationVO results = reservationService.bookTable(vo);
//		System.out.println(results);
//	}
//	
	@Test
	public void date() {
		List<ReservationVO> results = reservationService.findByDate(new java.sql.Date(new GregorianCalendar(2022, 11, 24).getTimeInMillis()));
		System.out.println(results);
	} 
	
	
//	@Override
//	public List<ReservationVO> getAll() {
//		return dao.getAll();
//	}
}
