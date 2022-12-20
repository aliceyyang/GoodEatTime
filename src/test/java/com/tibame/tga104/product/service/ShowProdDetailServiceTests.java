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
	
	@Test
	void testSelect6ByCategory() {
		System.out.println("random select 6 first trial="+svc.select6ByCategory(10));
		System.out.println("random select 6 second trial="+svc.select6ByCategory(10));
		System.out.println("random select 6 third trial="+svc.select6ByCategory(10));
	}
}
