package com.resale.background.redis;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resale.util.SerializeUtil;

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
            jedis.close();  
        }  
    }  
      
   public void set(byte[] bytes, byte[] serialize) {
	   	Jedis jedis = null;
	    try {  
    	jedis = jedisPool.getResource();  
    	jedis.set(bytes, serialize);
	    } finally {  
            jedis.close();  
        }  
    }
    
    
    public String get(String key){  
  
        Jedis jedis = null;  
        try {  
            jedis = jedisPool.getResource();  
            return jedis.get(key);  
        } finally {  
            jedis.close();  
        }  
    }  
    
    
    public byte[] get(byte[] bytes) {
	  Jedis jedis = null;  
      jedis = jedisPool.getResource();  
	  byte[] bs = jedis.get(bytes);  
	  return bs;
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
    
    /**
     * 设置键的过期时间
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key, int seconds) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, seconds);
		jedis.close();
		return result;
	}
    
    
    
    /**
	 * 删除redis中前缀为prefix,值为value的所有记录
	 * @param prefix
	 * @param value
	 */
	public void delByKeyprefixAndValue(String prefix,String value){
		Jedis jedis = jedisPool.getResource();
		Set<String> keys = jedis.keys(prefix+"*");
		if (keys!=null && keys.size()!=0) {
			for (String key : keys) {
				String thisValue = jedis.get(key);
				if (thisValue!=null) {
					if (thisValue.equals(value)) {
						jedis.del(key);
					}
				}
			}
		}
	}

	

	
}
