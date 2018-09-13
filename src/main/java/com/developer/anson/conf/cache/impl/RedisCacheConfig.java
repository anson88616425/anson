package com.developer.anson.conf.cache.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.redis.host")
public class RedisCacheConfig {

/*
    @Bean
    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory factory) {  
    	//factory.setPassword("foobared1");
    	 // RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>(); 
        StringRedisTemplate template = new StringRedisTemplate(factory);         
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);  
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(com.fasterxml.jackson.annotation.PropertyAccessor.ALL, com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        template.setValueSerializer(jackson2JsonRedisSerializer);  
        template.afterPropertiesSet();  
        template.setKeySerializer(jackson2JsonRedisSerializer);
        return template;  
    } 
  
    @Primary
    @Bean("expireCacheManager")
    public CacheManager expireCacheManager(RedisTemplate<String, String> redisTemplate) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<RedisCache> caches = new ArrayList<RedisCache>();  
        for(Caches c : Caches.values()){  
        	String cacheName = c.getCacheName();
        	caches.add(new RedisCache(cacheName, (cacheName).getBytes(), redisTemplate, c.getTtl()));
        }         
        cacheManager.setCaches(caches); 
        return cacheManager;  
    }  
    
    @Bean("clearableCacheManager")
    public CacheManager clearableCacheManager(RedisTemplate<String, String> redisTemplate) {
       RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);    
         // Number of seconds before expiration. Defaults to unlimited (0)  
        cacheManager.setDefaultExpiration(3000); // Sets the default expire time (in seconds)  
        return cacheManager;  
    }  */
    
}
