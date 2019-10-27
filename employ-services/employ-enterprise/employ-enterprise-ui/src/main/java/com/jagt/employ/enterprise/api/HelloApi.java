package com.jagt.employ.enterprise.api;

import com.jagt.employ.common.annotation.ApiResult;
import com.jagt.employ.common.annotation.Operation;
import com.jagt.employ.enterprise.dto.HelloDTO;
import com.jagt.employ.enterprise.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Api 对外接口
 * 
 * 用意在于为其他提供rest接口
 * 它的主要工作就是将一个用户请求委派给一个或多个应用层service进行处理。
 * 可选的工作：校验入参、将入参转为DTO传递给service层
 * 注解@RestController，方法返回json
 * 
 * @author gotanks
 *
 */
@RestController
@RequestMapping(value = "/api/enterprise/v1", method = RequestMethod.GET)
public class HelloApi {
	@Autowired
    HelloService helloService;
	
    /**
     * 调用自己服务
     * @param name
     * @return
     */
	@ApiResult // sgn: 需要加上此注解，自动封装返回对象
	@Operation("示例代码hello")  // sgn: 加上此注解，开启打印日志
    @RequestMapping(value = "/hello")
    public String sayHello(@RequestParam(required=false, defaultValue = "") String name,
                             @RequestParam(required=false) String token){
		name = name.trim();// sgn: 对传入参数进行简单的加工
		return helloService.sayHello(name);// sgn: 调用service层接口，业务逻辑都写在service层
    }
	
}
