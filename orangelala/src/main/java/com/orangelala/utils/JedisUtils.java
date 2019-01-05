package com.orangelala.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**  
* <p>Title: JedisUtils.java</p>  
* <p>Description:Jedits的工具类 </p>   
* @author QEcode  
* @date 2018年10月27日  
* @version 1.0  
*/ 
public class JedisUtils {
    
    private static JedisPool  jedisPool;
    
    static {
        JedisPoolConfig jedisConfig = new JedisPoolConfig();
        jedisConfig.setMaxTotal(100);
        jedisConfig.setMaxIdle(10);
        jedisConfig.setMaxWaitMillis(100);
        //主机名称和端口号，开启redis的服务器和端口号
        jedisPool = new JedisPool(jedisConfig, "127.0.0.1",6379);
    }
    
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis) {
        jedis.close();
    }


    
    
    
}
