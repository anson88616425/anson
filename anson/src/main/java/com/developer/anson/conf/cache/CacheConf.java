package com.developer.anson.conf.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;


@EnableCaching(proxyTargetClass = true)
public class CacheConf {

	public static final int DEFAULT_MAXSIZE = 50000;  
    public static final int DEFAULT_TTL = 10;  
	
    /** 
     * 定義cache名稱、超時時長（秒）、最大容量 
     * 每个cache缺省：10秒超时、最多缓存50000条数据，需要修改可以在构造方法的参数中指定。 
     */  
    public enum Caches {
       	
    	//shiro authorization缓存, 有效期1800s
    	shiroCache("com.edazone.erp.service.shiro.ShiroDbRealm.authorizationCache", 1800)
        ;  
          
    	
    	
        Caches() {  
        }  
        
        Caches(String cacheName) {  
        	this.cacheName = cacheName;
        } 
        
        Caches(int ttl) {  
            this.ttl = ttl;  
        }  
        
        Caches(String cacheName, int ttl) {  
        	this.cacheName = cacheName;
            this.ttl = ttl;  
        }  

        Caches(int ttl, int maxSize) {  
            this.ttl = ttl;  
            this.maxSize = maxSize;  
        }  
        
        Caches(String cacheName, int ttl, int maxSize) {  
        	this.cacheName = cacheName;
            this.ttl = ttl;  
            this.maxSize = maxSize;  
        }    
        
        private String cacheName = this.name();
        private int maxSize = CacheConf.DEFAULT_MAXSIZE;    //最大數量  
        private int ttl = CacheConf.DEFAULT_TTL;        //过期时间（秒）  
          
        public int getMaxSize() {  
            return maxSize;  
        }  
        public int getTtl() {  
            return ttl;  
        }
		public String getCacheName() {
			return cacheName;
		}
		public void setCacheName(String cacheName) {
			this.cacheName = cacheName;
		}
		public void setMaxSize(int maxSize) {
			this.maxSize = maxSize;
		}
		public void setTtl(int ttl) {
			this.ttl = ttl;
		}          
    }
    
    @Bean
    public KeyGenerator wiselyKeyGenerator(){
        return new KeyGenerator() {
            @Override  
            public Object generate(Object target, Method method, Object... params) {  
                StringBuilder sb = new StringBuilder();  
                sb.append(target.getClass().getName());  
                sb.append(method.getName());  
                for (Object obj : params) {  
                	if(obj!=null){
                		sb.append(obj.toString());  
                	} else {
                		sb.append("null");
                	}
                }  
                return sb.toString();  
            }  
        };    
    } 
    
}
