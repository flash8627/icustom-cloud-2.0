package com.gwtjs.icustom.cloud.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.cloud.GatewayServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { GatewayServiceApplication.class })
public class RedisTest {
	

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;

	@Test
	public void setTest() throws Exception {
		redisTemplate.opsForValue().set("author", "i custom flash8627 or a guang");
	}
	
	@Test
	public void getTest() throws Exception {
		Object obj = redisTemplate.opsForValue().get("author");
		System.out.println("\nredis result:"+obj.toString());
		//shi shu sheng
	}
	
}
