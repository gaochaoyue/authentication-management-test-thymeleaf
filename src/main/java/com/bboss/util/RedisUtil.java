package com.bboss.util;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


/*public class RedisUtil {

	
	@Autowired
	private JedisPool jedisPool;
	
	
	private static final RedisUtil redisUtil = new RedisUtil(); 
	
	 *//** 
     * 获取JedisUtil实例 
     * @return 
     *//*  
    public static RedisUtil getInstance() {  
        return redisUtil;   
    }  
	
	*//**
	 * 获取jedis实例
	 * 
	 * @return
	 *//*
	public synchronized  Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	*//**
	 * 释放jedis资源
	 * 
	 * @param jedis
	 *//*
	public  void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

	*//**
	 * 将数据放入redis
	 * 
	 * @param key
	 * @param value
	 *//*

	public void putInRedis(String key, String value, Integer expireSeconds) {
		Jedis jedis = getJedis();
		jedis.set(key, value);
		if (expireSeconds != null) {
			jedis.expire(key.getBytes(), expireSeconds.intValue());
		}
		returnResource(jedis);
	}

	public  void putInRedis(String key, Serializable value, Integer expireSeconds) {
		Jedis jedis = getJedis();
		jedis.set(key.getBytes(), SerializationUtils.serialize(value));
		if (expireSeconds != null) {
			jedis.expire(key.getBytes(), expireSeconds.intValue());
		}
		returnResource(jedis);
	}

	*//**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 *//*
	public  String getFromRedis(String key) {
		Jedis jedis = getJedis();
		String  str = null;
		try {
			if(jedis.exists(key)){
				str = jedis.get(key);
			}
			
		} catch (Exception e) {
			str = null;
		}
		returnResource(jedis);
		return str;
		
	}

	*//**
	 * 获取list类型的数据
	 * 
	 * @param key
	 * @return
	 *//*
	public  <T> List<T> getListFromRedis(String key) {
		Jedis jedis = getJedis();
		byte[] in =null;
		List<T> list  =null;
		if(jedis.exists(key)){
			in = jedis.get(key.getBytes());
			list = (List<T>) SerializationUtils.deserialize(in);
		}
		returnResource(jedis);
		return list;
	}
	
	*//**
	 * 获取Object类型的数据
	 * @param <T>
	 * 
	 * @param key
	 * @return
	 *//*
	public  <T> T getObjectFromRedis(String key) {
		Jedis jedis = getJedis();
		byte[] in =null;
		T t =null;
		if(jedis.exists(key)){
			in = jedis.get(key.getBytes());
			t = (T) SerializationUtils.deserialize(in);
		}
		returnResource(jedis);
		return t;
	}

	*//**
	 * 清除数据
	 * 
	 * @param key
	 *//*
	public  void deleteByKey(String key) {
		Jedis jedis = getJedis();
		jedis.del(key);
	}

	*//**
	 * 设置过期时间
	 * 
	 * @param key
	 *//*
	public  void setExpire(String key, int seconds) {
		Jedis jedis = getJedis();
		jedis.expire(key, seconds);
	}

}
*/