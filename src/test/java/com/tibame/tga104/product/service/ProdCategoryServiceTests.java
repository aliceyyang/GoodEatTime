package com.tibame.tga104.product.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ProdCategoryVO;

@SpringBootTest
public class ProdCategoryServiceTests {
	@Autowired
	private ProdCategoryService svc;
	
	@Test
	void testAddOneProdCategory() {
		ProdCategoryVO vo = svc.addProdCategory("測試svc新增");
		System.out.println(vo);
	}
	
	@Test
	void testUpdateProdCategory() {
		ProdCategoryVO vo = svc.updateProdCategory(21, "測試svc修改");
		assertTrue(vo.equals(svc.getOneProdCategory(21)));
	}
	
	@Test
	void testDeleteProdCategory() {
		svc.deleteProdCategory(27);
	}
	
	@Test
	void testGetOneProdCategory() {
		System.out.println(svc.getOneProdCategory(1));
	}
	
	@Test
	void testGetAll() {
		System.out.println(svc.getAll());
	}
}
