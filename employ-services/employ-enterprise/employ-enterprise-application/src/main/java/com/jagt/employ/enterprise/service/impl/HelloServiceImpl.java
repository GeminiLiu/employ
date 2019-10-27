package com.jagt.employ.enterprise.service.impl;

import com.jagt.employ.enterprise.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 应用服务实现类
 * @author gotanks
 */
@Slf4j
@RefreshScope// sgn: 配置中心修改后可以动态刷新
@Service
@Transactional
public class HelloServiceImpl implements HelloService {

	@Value("${employ.test:gotanks}")
	private String testProperties;
	
	@Override
	public String sayHello(String name) {
		log.info("name为： {}", name);// sgn： 关键信息一定要记录日志
		return "hello："+name+",配置参数为："+testProperties;
	}

}
