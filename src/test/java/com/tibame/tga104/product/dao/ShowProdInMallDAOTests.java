package com.tibame.tga104.product.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShowProdInMallDAOTests {
	@Autowired
	private ShowProdInMallDAO dao;
	
	@Test
	void testGetAll() {
		System.out.println(dao.getAll());
	}
	
	@Test
	void testGetFromProdCategory() {
		System.out.println(dao.getFromProdCategory(1));
	}
}
