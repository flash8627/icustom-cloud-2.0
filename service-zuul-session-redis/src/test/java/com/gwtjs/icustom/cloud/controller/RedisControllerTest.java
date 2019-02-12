package com.gwtjs.icustom.cloud.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.cloud.GatewayServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { GatewayServiceApplication.class })
public class RedisControllerTest {
	
	@Autowired
	private RedisController redisController;

	@Test
	public void setTest() throws Exception {
		redisController.setRedis("dong", "zhengguang");
	}
	
	@Test
	public void getTest() throws Exception {
		String result = redisController.getRedis("dong");
		System.out.println("\nredis result:"+result.toString());
		//shi shu sheng
	}
	
}
