package com.resale.foreground.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component 
public class RedisClient {

	
	@Autowired  
    private JedisPool jedisPool;  
     
	
    public void set(String key, String value){  
        Jedis jedis = null;  
        try {  
            jedis = jedisPool.getResource();  
            jedis.set(key, value);  
        } finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }  
      
    public String get(String key){  
  
        Jedis jedis = null;  
        try {  
            jedis = jedisPool.getResource();  
            return jedis.get(key);  
        } finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }  
    
    public Long delete(String key){  
    	  
        Jedis jedis = null;  
        try {  
            jedis = jedisPool.getResource();  
            return jedis.del(key);
        } finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }  
}
