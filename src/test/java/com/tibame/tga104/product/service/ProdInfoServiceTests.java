package com.tibame.tga104.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ProdInfoVO;

@SpringBootTest
public class ProdInfoServiceTests {
	@Autowired
	private ProdInfoService service;

	@Test
	void testAddProdInfo() {
		ProdInfoVO newProduct = service.addProdInfo(3, 3, "serviceAdd", 3, 3, "serviceAdd1", "serviceAdd2", 12, 12);
		System.out.println("testAddProdInfo()="+newProduct);
	}
	
	@Test
	void testUpdateProdInfo() {
		ProdInfoVO updateProduct = service.updateProdInfo(15, 3, 3, "service修改", 1, 1, "service修改1", "service修改2", 1, 5);
		System.out.println("testUpdateProdInfo()="+updateProduct);
	}
	
	@Test
	void testDeleteProdInfo() {
		System.out.println("testDeleteProdInfo()="+service.deleteProdInfo(16));
	}
	
	@Test
	void testGetOneProduct() {
		System.out.println("testGetOneProduct()="+service.getOneProduct(1));
	}
	
	@Test
	void testGetAll() {
		System.out.println("testGetAll()="+service.getAll());
	}
	
	@Test
	void testGetByCategory() {
		System.out.println("testGetByCategory()="+service.getByCategory(3));
	}
}
