package com.tibame.tga104.order.dao;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.order.vo.ProdOrderVO;

@SpringBootTest
public class ProdOrderDAO_HibernateTests {
	
	@Autowired
	ProdOrderDAO_interface dao;
	
	@Test
	void testInsert() {
		ProdOrderVO prodOrderVO_insert = new ProdOrderVO();
		prodOrderVO_insert.setMemberNo(5);
		prodOrderVO_insert.setRestaurantNo(3);
		prodOrderVO_insert.setCouponNo(null);
		prodOrderVO_insert.setOrderStatus("訂單成立");
		prodOrderVO_insert.setProdOrderDate(new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));
		prodOrderVO_insert.setProdOrderReveiveTime(java.sql.Timestamp.valueOf("2022-11-28 05:46:00"));
		prodOrderVO_insert.setProdOderDeliverTime(java.sql.Timestamp.valueOf("2022-11-28 10:46:00"));
		prodOrderVO_insert.setDeliverFee(0);
		prodOrderVO_insert.setAmountBeforeCoupon(500);
		prodOrderVO_insert.setAmountAfterCoupon(500);
		prodOrderVO_insert.setProdOrderPoint(0);
		prodOrderVO_insert.setProdOrderReceiverName("李佳欣");
		prodOrderVO_insert.setProdOrderReceiverTel("0958-345678");
		prodOrderVO_insert.setProdOrderReceiverMail("tibame6@gmail.com");
		prodOrderVO_insert.setProdOrderReceiverAddress("台北市信義區吳興街250號");
		prodOrderVO_insert.setInvoiceNumber("AB-67890123");
		prodOrderVO_insert.setTaxIDNumber(null);
		dao.insert(prodOrderVO_insert);
	}
	
//	@Test
//	void testDelete() {
//		dao.delete(3);
//	}
	
	@Test
	void testUpdate() {
		ProdOrderVO prodOrderVO_update = dao.select(1);
		prodOrderVO_update.setProdOrderReceiverName("黃郁婕");
		dao.update(prodOrderVO_update);
	}
	
	@Test
	void testSelect() {
		System.out.println("testSelect()= " + dao.select(2));
	}
	
	@Test
	void testGetall() {
		System.out.println("testGetall()= " + dao.getAll());
	}

}