package com.tibame.tga104;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration {
	@Bean
	RedisTemplate<Integer, HashMap<Integer, Integer>> shoppingCartTemplate(
			RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Integer, HashMap<Integer, Integer>> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
	
	  @Bean
	  StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {

	    StringRedisTemplate template = new StringRedisTemplate();
	    template.setConnectionFactory(redisConnectionFactory);
	    return template;
	  }
	
	
}
