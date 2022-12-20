package com.tibame.tga104.order.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.order.vo.ProdOrderDetailVO;

@SpringBootTest
public class ProdOrderDetailDAOTests {
	@Autowired
	ProdOrderDetailDAO_interface dao;
	
	/* 測試已測完，基礎測試接ok
	 * 移除DAO的@Transactional annotation至Service
	 * 後續若要再測試的話需補上此annotation
	 * */
	
//	@Test
	void testInsert() {
		ProdOrderDetailVO vo = new ProdOrderDetailVO();
		vo.setProdOrderNo(1);
		vo.setProdNo(7);
		vo.setProdQty(20);
//		vo.setProdPrice(150);
		System.out.println(dao.insert(vo));
	}
	
//	@Test
	void testUpdate() {
		ProdOrderDetailVO vo = new ProdOrderDetailVO();
		vo.setProdOrderNo(1);
		vo.setProdNo(7);
		vo.setProdQty(18);
//		vo.setProdPrice(150);
		
		dao.update(vo);
	}
	
//	@Test
	void testDelete() {
		dao.delete(1, 7);
	}
	
//	@Test
	void testselect1() {
		System.out.println(dao.select(1, 1));
	}
	
//	@Test
	void testselect2() {
		System.out.println(dao.select(1));
	}
	
	@Test
	void testGetAll() {
		System.out.println(dao.getAll());
	}
}
