package com.jagt.employ.common.cache.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.jagt.employ.common.cache.caffeine.CacheItem;
import lombok.Data;

@Data
@ConfigurationProperties(prefix = "employ.cache", ignoreUnknownFields = false)
public class CacheConfigProps {
    
    private List<CacheItem> caffeine = new ArrayList<CacheItem>();
    
}
