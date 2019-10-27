package com.jagt.employ.common.cache.caffeine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;

import com.jagt.employ.common.cache.config.CacheConfigProps;
import lombok.extern.slf4j.Slf4j;

/**
 * 缓存配置类
 * @author gotanks
 */
@Slf4j
@Configuration
@EnableCaching
@EnableConfigurationProperties(CacheConfigProps.class)
public class CacheConfig {

    @Autowired
    CacheConfigProps configProps;
	/**
	 * 必须要指定这个Bean，refreshAfterWrite=5s这个配置属性才生效
	 * @return
	 */
	@Bean
	public CacheLoader<Object, Object> cacheLoader() {
	    return new CacheLoader<Object, Object>() {
	        @Override
	        public Object load(Object key) throws Exception {
	            log.debug("cacheLoader load : {}", key);
	            return null;
	        }
	        // 重写这个方法将oldValue值返回回去，进而刷新缓存
	        @Override
	        public Object reload(Object key, Object oldValue) throws Exception {
                log.debug("cacheLoader reload : {}->{}", key, oldValue);
	            return oldValue;
	        }
	    };
	}
	
	/**
     * 创建基于Caffeine的Cache Manager
     * @return
     */
    @Bean
    @Primary
    public CacheManager cacheManager() {
        log.info("cache manager initialize ...");
        ArrayList<CaffeineCache> caches = new ArrayList<CaffeineCache>();
        List<CacheItem> caffeineCacheItem = configProps.getCaffeine();
        if(caffeineCacheItem != null) {
            try {
                for(CacheItem c : caffeineCacheItem){
                    @NonNull
                    Cache<Object, Object> cache = Caffeine.newBuilder()
                    .recordStats()
                    .refreshAfterWrite(c.getRefreshAfterWrite(), TimeUnit.SECONDS)
                    .expireAfterWrite(c.getExpireAfterWrite(), TimeUnit.SECONDS)
                    .maximumSize(c.getMaximumSize())
                    .build(key -> load(key));
                    log.debug("cacheLoader load : {}", c.getName());
                    caches.add(new CaffeineCache(c.getName(), cache));
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("cacheLoader load : no cache");
            }
        }
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caches);
 
        return cacheManager;
    }
    
    private Object load(Object key) throws Exception {
        log.debug("cacheLoader load : {}", key);
        return null;
    }
//    Caffeine配置说明：
//
//    initialCapacity=[integer]: 初始的缓存空间大小
//    maximumSize=[long]: 缓存的最大条数
//    maximumWeight=[long]: 缓存的最大权重
//    expireAfterAccess=[duration]: 最后一次写入或访问后经过固定时间过期
//    expireAfterWrite=[duration]: 最后一次写入后经过固定时间过期
//    refreshAfterWrite=[duration]: 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存
//    weakKeys: 打开key的弱引用
//    weakValues：打开value的弱引用
//    softValues：打开value的软引用
//    recordStats：开发统计功能
//
//    注意：
//
//    expireAfterWrite和expireAfterAccess同事存在时，以expireAfterWrite为准。
//    maximumSize和maximumWeight不可以同时使用
//    weakValues和softValues不可以同时使用

}
