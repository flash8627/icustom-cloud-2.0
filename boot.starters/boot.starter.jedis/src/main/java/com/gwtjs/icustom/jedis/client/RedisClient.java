package com.gwtjs.icustom.jedis.client;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

/**
 * 就一个小Demo 随便写下
 * @author bigsea
 *
 */
public class RedisClient {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(RedisClient.class);
	
	@Autowired
	private JedisPool jedisPool;
	
	public void set(String key, String value) throws Exception {
		Jedis jedis = null;
		try {
			log.info("jedis pool:"+jedisPool);
			log.info("jedis pool Resource:"+jedisPool.getResource());
			jedis = jedisPool.getResource();
			log.info("jedis:"+jedis);
			jedis.set(key, value);
		} finally {
			//返还到连接池
			jedis.close();
		}
	}
	
	public String get(String key) throws Exception  {

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.get(key);
		} finally {
			//返还到连接池
			jedis.close();
		}
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
}
