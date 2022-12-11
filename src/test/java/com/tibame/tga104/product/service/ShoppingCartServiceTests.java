package com.tibame.tga104.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ShoppingCartVO;

@SpringBootTest
public class ShoppingCartServiceTests {
	@Autowired
	ShoppingCartService svc;
	
	@Test
	void testInsert() {
		ShoppingCartVO insert = new ShoppingCartVO();
		insert.setMemberNo(5);
		insert.setProdNo(10);
		insert.setProdQty(15);
		System.out.println("testInsert()="+svc.insert(insert));
	}
	
	@Test
	void testUpdate() {
		ShoppingCartVO update = new ShoppingCartVO();
		update.setMemberNo(5);
		update.setProdNo(10);
		update.setProdQty(3);
		System.out.println("testUpdate()="+svc.update(update));
	}
	
	@Test
	void testDelete() {
		System.out.println("testDelete()="+svc.delete(5, 10));
	}
	
	@Test
	void testFindByPrimaryKey() {
		System.out.println("testFindByPrimaryKey()="+svc.findByPrimaryKey(3, 4));
	}
	
	@Test
	void testGetAll() {
		System.out.println("testGetAll()"+svc.getAll());
	}
	
	@Test
	void testFindByMemberNo() {
		System.out.println("testFindByMemberNo()"+svc.findByMemberNo(2));
	}
}
