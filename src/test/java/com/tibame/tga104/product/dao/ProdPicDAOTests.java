package com.tibame.tga104.product.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ProdPicVO;

@SpringBootTest
public class ProdPicDAOTests {
	@Autowired
	private ProdPicDAO dao;
	
	/* 測試已測完，基礎測試接ok
	 * 移除DAO的@Transactional annotation至Service
	 * 後續若要再測試的話需補上此annotation
	 * */
	
	@Test
	void testInsert () {
		ProdPicVO insert = new ProdPicVO();
		insert.setProdNo(4);
		insert.setProdPicRemark("測試spring boot新增");
		try (InputStream in = Files.newInputStream(Path.of("C:\\GoodEatTime\\Workspace\\GoodEatTime\\src\\main\\resources\\static\\Front_End\\img\\shop\\product-9.jpg"))){
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			insert.setProdPic(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(dao.insert(insert));
	}
	
	@Test
	void testUpdate () {
		ProdPicVO update = dao.findByPrimaryKey(7);
		update.setProdPicRemark("測試springboot修改");
		try (InputStream in = Files.newInputStream(Path.of("C:\\GoodEatTime\\Workspace\\GoodEatTime\\src\\main\\resources\\static\\Front_End\\img\\shop\\product-2.jpg"))){
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			update.setProdPic(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dao.update(update);
	}
	
	@Test
	void testDelete () {
		dao.delete(12);
	}
	
	@Test
	void testFindByPrimaryKey () {
		System.out.println(dao.findByPrimaryKey(8));
	}
	
	@Test
	void testGetAll () {
		System.out.println(dao.getAll());
	}
	
	@Test
	void testFindByProdNo() {
		System.out.println(dao.findByProdNo(4));
	}
}
