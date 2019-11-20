package com.jagt.employ.interview.domain.service;

import com.jagt.employ.interview.domain.repository.HelloRepository;
import com.jagt.employ.interview.infra.command.impl.DomainServiceImpl;
import com.jagt.employ.interview.infra.constants.DB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HelloDomainService extends DomainServiceImpl {

//	@Autowired
//	private HelloRepository helloRepository;

    public void setValue(String name, String value) {
		DB.DB_MAP.put(name, value);
    }
}
