package com.tibame.tga104.product.injector;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga104.product.service.ProdInfoService;
import com.tibame.tga104.product.vo.ProdInfoVO;

@SpringBootTest
public class ProdMainPicInjector {
	@Autowired
	private ProdInfoService svc;
	
	@Test
	void picInjector() {
		String picPath = "C:\\GoodEatTime\\Workspace\\GoodEatTime\\src\\main\\resources\\static\\Front_End\\img\\shop\\product\\";
		for (int i = 1; i < 25; i++) {
			ProdInfoVO vo = svc.getOneProduct(i);
			try (InputStream in = Files.newInputStream(Path.of(picPath+i+".jpg"))){
				byte[] bytes = new byte[in.available()];
				in.read(bytes);
				vo.setProdMainPic(bytes);
			}catch(IOException e) {
				e.printStackTrace();
			}
			svc.update(vo);
		}
	}
}
