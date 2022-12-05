package com.tibame.tga104.reservation.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tibame.tga104.common.connection.HibernateUtil;
import com.tibame.tga104.reservation.vo.ReservationVO;

public class ReservationTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
//insert
//		ReservationVO insert = new ReservationVO();
//		insert.setReserveNum(20);
//		insert.setReserveDate(new java.sql.Date(new GregorianCalendar(2022, 12, 21).getTimeInMillis()));
//		insert.setReserveTime("12:00");
//		insert.setRestaurantNo(5);
//		insert.setMemberNo(2);
//		insert.setReserveStatus("訂位成功");
//		insert.setRemark(null);
//		insert.setCommentContent(null);
//		insert.setCommentRating(null);
//		insert.setCommentPic(null);
//		insert.setRestaurantRe(null);
//		
//		session.save(insert);
		
//select
		ReservationVO select = session.get(ReservationVO.class, 4);
		System.out.println("select="+select);
		
//update
//		ReservationVO update = session.get(ReservationVO.class, 80);
//		update.setDeptname("hohoho");
		
//delete		
//		DeptBean delete = session.get(DeptBean.class, 80);
//		session.delete(delete);
		
//		ReservationVO insert = new DeptBean();
//		insert.setDeptid(70);
//		session.delete(insert);
		
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
