package com.jagt.employ.user.query.service;

import com.jagt.employ.user.infra.command.impl.QueryServiceImpl;
import com.jagt.employ.user.infra.constants.DB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CQRS 查询层
 *
 * 所有对数据库的读操作写在这里
 * 使用jooq或mybatis直接查出需要的ViewModel（DTO）,不需要调用领域层
 * 与command层老死不相往来（不能互相调用）
 *
 * @author gotanks
 *
 */
@Slf4j
@RefreshScope// sgn: 配置中心修改后可以动态刷新
@Service
@Transactional
public class HelloQueryService extends QueryServiceImpl {

    @Value("${employ.test:}")
    private String prefix;

    @Cacheable(value = "hello", key="#p0")// sgn: 缓存，一般在领域层使用缓存，这里只是示例
    public String getValue(String name) {
        return prefix + DB.DB_MAP.get(name);
    }
}
