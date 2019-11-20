package com.jagt.employ.interview.app.service;

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
    String set(String name, String value);

    /**
     * 接口方法必须添加注释
     * @param name
     * @return
     */
    String get(String name);

}
