package com.jagt.employ.student.resume;

import com.jagt.employ.student.resume.dto.HelloDTO;

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
    void set(String name, String value);

    /**
     * 接口方法必须添加注释
     * @param name
     * @return
     */
    HelloDTO get(String name);

}
