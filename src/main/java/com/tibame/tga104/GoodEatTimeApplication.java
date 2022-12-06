package com.tibame.tga104;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class GoodEatTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodEatTimeApplication.class, args);
	}

}
