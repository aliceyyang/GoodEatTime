package com.tibame.tga104.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedisController {
	
	@Autowired
	RedisTemplate<String, String> redistemplate;
	
	@RequestMapping("/redis/add")
	public String addRedis() {
		redistemplate.opsForValue().set("RedisTest", "Hello World");
		return "success";
	}
	
	@RequestMapping("/redis/get")
	public String getRedis() {
		return redistemplate.opsForValue().get("RedisTest");
	}
}
