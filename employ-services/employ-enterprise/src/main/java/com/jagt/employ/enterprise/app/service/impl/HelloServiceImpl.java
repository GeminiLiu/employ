package com.jagt.employ.enterprise.app.service.impl;

import com.jagt.employ.enterprise.app.cmd.SetHelloCmd;
import com.jagt.employ.enterprise.app.qry.GetValueQry;
import com.jagt.employ.enterprise.app.service.HelloService;
import com.jagt.employ.enterprise.infra.command.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
public class HelloServiceImpl extends ServiceImpl implements HelloService {

	@Override
	public String set(String name, String value) {
		commandExecutor.execute(new SetHelloCmd(name, value));
		return null;
	}

	@Override
	public String get(String name) {
		String value = queryExecutor.execute(new GetValueQry(name));
		return value;
	}

}
