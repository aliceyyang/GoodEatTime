package com.tibame.tga104.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShowProdDetailServiceTests {
	@Autowired
	private ShowProdDetailService svc;
	
	@Test
	void testSelect() {
		System.out.println(svc.select(2));
	}
}
