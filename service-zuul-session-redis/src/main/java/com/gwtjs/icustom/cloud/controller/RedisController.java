package com.gwtjs.icustom.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
	
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	@GetMapping("/redis/get")
	public String getRedis(String redisKey) {
		Object obj = redisTemplate.opsForValue().get(redisKey);
		if(obj!=null)
		return obj.toString();
		
		return "SUCCESS";
	}
	
	@PostMapping("/redis/set")
	public String setRedis(String redisKey,String redisValue) {
		redisTemplate.opsForValue().set(redisKey, redisValue);
		return "SUCCESS";
	}
	
}
