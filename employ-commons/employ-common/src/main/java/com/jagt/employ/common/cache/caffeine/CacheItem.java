package com.jagt.employ.common.cache.caffeine;

import lombok.Data;

@Data
public class CacheItem {
    // 缓存名
    private String name;
    // 缓存的最大条数
    private Integer maximumSize = 10000;
    // 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存
    private Integer refreshAfterWrite = 30*60;
    // 最后一次写入后经过固定时间过期
    private Integer expireAfterWrite = 40*60;
}
