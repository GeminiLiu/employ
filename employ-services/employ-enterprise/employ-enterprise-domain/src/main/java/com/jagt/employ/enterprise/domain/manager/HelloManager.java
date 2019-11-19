package com.jagt.employ.enterprise.domain.service;

import com.jagt.employ.common.exception.BusinessException;
import com.jagt.employ.enterprise.constant.enums.E;
import com.jagt.employ.enterprise.domain.entity.Hello;
import com.jagt.employ.enterprise.domain.repository.HelloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Manager 业务服务层
 * 
 * 区别于应用服务，他属于业务领域层。
 * 可以认为，如果某种行为无法归类给任何实体/值对象，则就为这些行为建立相应的领域服务即可。
 * 
 * @author gotanks
 *
 */
@Slf4j
@Service
public class HelloManager {

//	@Value("${ms.test}")
//	private String testProperties;

	@Autowired
	private HelloRepository helloRepository;

	@Cacheable(value = "hello", key="#p0")// sgn: 缓存，一般在领域层使用缓存，这里只是示例
    public Hello getOneHello(String name) {
//		Hello hello = helloRepository.findById(0L).orElse(null);
		Hello hello = new Hello();// sgn: 示例未连接数据源，所以这里new一个
		if(!"".equals(name)) {
			hello.setName(name+System.currentTimeMillis());
		}else {
			throw new BusinessException(E.E001.info());
		}
		return hello;
    }
}
