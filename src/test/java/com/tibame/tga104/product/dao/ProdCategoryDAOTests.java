package com.tibame.tga104.product.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ProdCategoryVO;

@SpringBootTest
public class ProdCategoryDAOTests {
	@Autowired
	ProdCategoryDAO dao;	
	
	@Test
	void testFindByPrimaryKey() {
		System.out.println(dao.findByPrimaryKey(1));
	}
	
	@Test
	void testInsert() {
		ProdCategoryVO myProductCategory = new ProdCategoryVO();
		myProductCategory.setProdCategory("~~測試新增~~");
		System.out.println(dao.insert(myProductCategory));
	}
	
	@Test
	void testUpdate() {
		ProdCategoryVO myProductCategory = dao.findByPrimaryKey(13);
		myProductCategory.setProdCategory("~~測試修改~~");
		dao.update(myProductCategory);
		System.out.println(myProductCategory);
	}
	
	@Test
	void testDelete() {
		System.out.println(dao.findByPrimaryKey(14));
		dao.delete(15);
		System.out.println(dao.findByPrimaryKey(14));
	}
	
	@Test
	void testGetAll() {
		System.out.println(dao.getAll());
	}
}
