package com.tibame.tga104.product.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ProdInfoVO;

@SpringBootTest
public class ProdInfoTests {
	@Autowired
	ProdInfoDAO dao;
	
	@Test
	void testInsert() {
		ProdInfoVO myProduct = new ProdInfoVO();
		myProduct.setRestaurantNo(2);
		myProduct.setProdCategoryNo(4);
		myProduct.setProdName("測試Hibernate新增商品~~~");
		myProduct.setProdPrice(999);
		myProduct.setProdStock(123);
		myProduct.setProdDescription("測試11");
		myProduct.setProdContent("測試22");
		myProduct.setProdCommentQty(0);
		myProduct.setTotalCommentRating(0);
		System.out.println("testInsert()="+dao.insert(myProduct));
	}
	
	@Test
	void testUpdate() {
		ProdInfoVO myProduct = dao.findByPrimaryKey(12);
		myProduct.setProdPrice(999999);
		myProduct.setProdStock(999999);
		myProduct.setProdCommentQty(100);
		myProduct.setTotalCommentRating(495);
		System.out.println("testUpdate()="+dao.update(myProduct));
	}
	
	@Test
	void testDelete() {
		System.out.println("testDelete()="+dao.delete(14));
	}
	
	@Test
	void testFindByPrimaryKey() {
		System.out.println("testFindByPrimaryKey()="+dao.findByPrimaryKey(8));
	}
	
	@Test
	void testGetAll() {
		System.out.println("testGetAll()="+dao.getAll());
	}
	
	@Test
	void testFindByProdCategory() {
		System.out.println("testFindByProdCategory()="+dao.findByProdCategory(2));
	}
}
