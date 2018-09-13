package com.developer.anson.conf.cache.impl;

import com.developer.anson.conf.cache.CacheConf;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author ericisme
 *
 */
@Configuration
public class CaffeineCacheConfig {
	
    /** 
     * 创建基于Caffeine的Cache Manager 
     * 高并发时有bug
     * @return 
     */  
    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caches = new ArrayList<CaffeineCache>();
        for(CacheConf.Caches c : CacheConf.Caches.values()){
        	String cacheName = c.getCacheName();
            caches.add(new CaffeineCache(cacheName,   
            		Caffeine.newBuilder().recordStats()
                .expireAfterWrite(c.getTtl(), TimeUnit.SECONDS)  
                .maximumSize(c.getMaxSize())  
                .build())  
            );  
        }            
        cacheManager.setCaches(caches);  
        return cacheManager;  
    }


    
}
