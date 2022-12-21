package com.tibame.tga104.product.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ShoppingCartVO;

@SpringBootTest
public class ShoppingCartDAOTests {
	@Autowired
	ShoppingCartDAO dao;
	
	/* 測試已測完，基礎測試接ok
	 * 移除DAO的@Transactional annotation至Service
	 * 後續若要再測試的話需補上此annotation
	 * 
	 * 改用Redis
	 * */
	
	@Test
	void testInsert() {
		ShoppingCartVO insert = new ShoppingCartVO();
		insert.setMemberNo(5);
		insert.setProdNo(3);
		insert.setProdQty(10);
		System.out.println("testInsert()="+dao.insert(insert));
	}
	
	@Test
	void testUpdate() {
		ShoppingCartVO update = new ShoppingCartVO();
		update.setMemberNo(5);
		update.setProdNo(10);
		update.setProdQty(3);
		System.out.println("testUpdate()="+dao.update(update));
	}
	
	@Test
	void testDelete() {
		System.out.println("testDelete()="+dao.delete(5, 10));
	}
	
	@Test
	void testFindByPrimaryKey() {
		System.out.println("testFindByPrimaryKey()="+dao.findByPrimaryKey(5, 10));
	}
	
	@Test
	void testGetAll() {
		System.out.println("testGetAll()="+dao.getAll());
	}
	
	@Test
	void testFindByMemberNo() {
		System.out.println("testFindByMemberNo()="+dao.findByMemberNo(2));
	}
}
