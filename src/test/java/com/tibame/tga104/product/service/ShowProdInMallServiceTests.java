package com.tibame.tga104.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShowProdInMallServiceTests {
	@Autowired
	private ShowProdInMallService svc;
	
	@Test
	void testGetAll() {
		System.out.println(svc.getAll());
	}
	
	@Test
	void testGetFromProdCategory() {
		System.out.println(svc.getFromProdCategory(2));
	}
}
