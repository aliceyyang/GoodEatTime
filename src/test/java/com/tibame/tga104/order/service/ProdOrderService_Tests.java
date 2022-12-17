package com.tibame.tga104.order.service;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.order.vo.ProdOrderVO;

@SpringBootTest
public class ProdOrderService_Tests {
	
	@Autowired
	private ProdOrderService prodOrderService;
	
	@Test
	void testInsert() {
		ProdOrderVO prodOrderVO = prodOrderService.insertProdOrder(2, 2, 10, "已寄出" , new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()),	
				java.sql.Timestamp.valueOf("2022-12-16 11:10:00"), java.sql.Timestamp.valueOf("2022-12-16 11:20:30"), 
				100, 500, 500, 100, "測試用2", "0958-111222", "tibame10@gmail.com", "台北市信義區吳興街250號", "AB-67890123", "80518858");
		System.out.println("testInsert()="+prodOrderVO);
	}
	
//	@Test
//	void testDelete() {
//		prodOrderService.deleteProdOrder(2));
//	}
	
	@Test
	void testUpdate() {
		ProdOrderVO prodOrderVO = prodOrderService.updateProdOrder(4, 2, 2, 10, "已寄出" , new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()),	
				java.sql.Timestamp.valueOf("2022-12-16 11:10:00"), java.sql.Timestamp.valueOf("2022-12-16 11:20:30"), 
				100, 500, 500, 100, "游育碩", "0958-111222", "tibame10@gmail.com", "台北市信義區吳興街250號", "AB-67890123", "80518858");
		System.out.println("testUpdate()="+prodOrderVO);
	}
	
	@Test
	void testSelect() {
		System.out.println("testSelect()="+prodOrderService.select(5));
	}
	
	@Test
	void testGetall() {
		System.out.println("testGetall()="+prodOrderService.getAll());
	}

}

