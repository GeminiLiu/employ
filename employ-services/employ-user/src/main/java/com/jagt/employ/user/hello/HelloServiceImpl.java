package com.jagt.employ.user.hello;

import com.jagt.employ.common.cqrs.impl.ServiceImpl;
import com.jagt.employ.user.hello.command.GetValueQry;
import com.jagt.employ.user.hello.command.SetHelloCmd;
import com.jagt.employ.user.hello.dto.HelloDTO;
import org.springframework.stereotype.Service;

/**
 * 应用服务实现类
 * @author gotanks
 */
@Service
public class HelloServiceImpl extends ServiceImpl implements HelloService {

	@Override
	public void set(String name, String value) {
		//采用命令模式，创建并发布一个个命令
		commandExecutor.execute(new SetHelloCmd(name, value));
	}

	@Override
	public HelloDTO get(String name) {
		return queryExecutor.execute(new GetValueQry(name));
	}

}
