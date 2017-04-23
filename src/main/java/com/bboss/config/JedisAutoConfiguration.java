package com.bboss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration  
@EnableConfigurationProperties(JedisProperties.class)//开启属性注入,通过@autowired注入 
public class JedisAutoConfiguration {
	
	@Autowired  
    private JedisProperties prop;  
      
    @Bean(name="jedisPool")  
    public JedisPool jedisPool() {  
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxTotal(prop.getMaxTotal());  
        config.setMaxIdle(prop.getMaxIdle());  
        config.setMaxWaitMillis(prop.getMaxWaitMillis());  
        return new JedisPool(config, prop.getHost(), prop.getPort(), prop.getTimeout(),prop.getPassword());
    }  

}
