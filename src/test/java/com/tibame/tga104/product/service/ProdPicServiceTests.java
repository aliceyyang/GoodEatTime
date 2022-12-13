package com.tibame.tga104.product.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.vo.ProdPicVO;

@SpringBootTest
public class ProdPicServiceTests {
	@Autowired
	private ProdPicService svc;
	
	@Test
	void testAddProdPic () {
		try (InputStream in = Files.newInputStream(Path.of("C:\\GoodEatTime\\Workspace\\GoodEatTime\\src\\main\\resources\\static\\Front_End\\img\\shop\\product-7.jpg"))){
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			System.out.println(svc.addProdPic(10, bytes, "測試service新增"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testUpdateProdPic () {
		try (InputStream in = Files.newInputStream(Path.of("C:\\GoodEatTime\\Workspace\\GoodEatTime\\src\\main\\resources\\static\\Front_End\\img\\shop\\product-5.jpg"))){
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			ProdPicVO vo = svc.updateProdPic(11, 5, bytes, "~~測試service修改~~");
			assertTrue(vo.equals(svc.getOneProdPic(11)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeleteProdPic () {
		System.out.println("測試刪除");
		System.out.println(svc.deleteProdPic(14));
	}
	
	@Test
	void testOneGetProdPic () {
		System.out.println("測試主鍵查詢");
		System.out.println(svc.getOneProdPic(8));
	}
	
	@Test
	void testGetAll () {
		System.out.println("測試查全部");
		System.out.println(svc.getAll());
	}
	
	@Test
	void testFindByProdNo () {
		System.out.println("測試用產品編號查找");
		System.out.println(svc.findByProdNo(4));
	}
}
