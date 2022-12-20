package com.tibame.tga104.product.injector;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.dao.ShoppingCartDAO;
import com.tibame.tga104.product.vo.ShoppingCartVO;

@SpringBootTest
public class RedisInjector {
	@Autowired
	ShoppingCartDAO dao;
	
	@Test
	void shoppingCartInjector() {
		ShoppingCartVO insert1 = new ShoppingCartVO();
		insert1.setMemberNo(5);
		insert1.setProdNo(3);
		insert1.setProdQty(10);
		System.out.println("testInsert()="+dao.insert(insert1));
		
		ShoppingCartVO insert2 = new ShoppingCartVO();
		insert2.setMemberNo(5);
		insert2.setProdNo(2);
		insert2.setProdQty(6);
		System.out.println("testInsert()="+dao.insert(insert2));
		
		ShoppingCartVO insert3 = new ShoppingCartVO();
		insert3.setMemberNo(5);
		insert3.setProdNo(7);
		insert3.setProdQty(1);
		System.out.println("testInsert()="+dao.insert(insert3));

		ShoppingCartVO insert4 = new ShoppingCartVO();
		insert4.setMemberNo(5);
		insert4.setProdNo(1);
		insert4.setProdQty(1);
		System.out.println("testInsert()="+dao.insert(insert4));

		ShoppingCartVO insert5 = new ShoppingCartVO();
		insert5.setMemberNo(5);
		insert5.setProdNo(12);
		insert5.setProdQty(2);
		System.out.println("testInsert()="+dao.insert(insert5));

		ShoppingCartVO insert6 = new ShoppingCartVO();
		insert6.setMemberNo(5);
		insert6.setProdNo(15);
		insert6.setProdQty(1);
		System.out.println("testInsert()="+dao.insert(insert6));

		ShoppingCartVO insert7 = new ShoppingCartVO();
		insert7.setMemberNo(5);
		insert7.setProdNo(16);
		insert7.setProdQty(1);
		System.out.println("testInsert()="+dao.insert(insert7));

		ShoppingCartVO insert8 = new ShoppingCartVO();
		insert8.setMemberNo(5);
		insert8.setProdNo(17);
		insert8.setProdQty(2);
		System.out.println("testInsert()="+dao.insert(insert8));

		ShoppingCartVO insert9 = new ShoppingCartVO();
		insert9.setMemberNo(5);
		insert9.setProdNo(21);
		insert9.setProdQty(2);
		System.out.println("testInsert()="+dao.insert(insert9));
		
		ShoppingCartVO insert10 = new ShoppingCartVO();
		insert10.setMemberNo(5);
		insert10.setProdNo(22);
		insert10.setProdQty(3);
		System.out.println("testInsert()="+dao.insert(insert10));
	
	}
	
}
