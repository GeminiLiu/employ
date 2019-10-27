package com.jagt.employ.enterprise.service;

/**
 * Service 应用服务层
 * 
 * 应用服务层，提供不需要与数据库交互的业务逻辑
 * 
 * @author gotanks
 *
 */
public interface HelloService {
    /**
     * 接口方法必须添加注释
     * @param name
     * @return
     */
    String sayHello(String name);
    
}
