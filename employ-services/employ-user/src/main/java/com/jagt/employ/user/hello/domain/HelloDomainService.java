package com.jagt.employ.user.hello.domain;

import com.jagt.employ.common.cqrs.impl.DomainServiceImpl;
import com.jagt.employ.user.hello.domain.entity.HelloE;
import com.jagt.employ.user.hello.domain.vo.HelloV;
import com.jagt.employ.user.infra.constants.DB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@RefreshScope// sgn: 配置中心修改后可以动态刷新
@Service
@Transactional
public class HelloDomainService extends DomainServiceImpl {

	@Autowired
	private HelloRepository helloRepository;

    public void setValue(String name, String value) {
        //采用build模式构建实体类
        HelloE hello = HelloE.builder()
                .name(name)
                .msg(value)
                .helloV(new HelloV(System.currentTimeMillis() + ""))
                .build();
        //缓存模拟数据库操作
        DB.DB_MAP.put(name, value);
        //真实数据库操作
        helloRepository.save(hello);
    }
}
