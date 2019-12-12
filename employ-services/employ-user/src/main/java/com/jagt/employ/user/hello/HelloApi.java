package com.jagt.employ.user.hello;

import com.jagt.employ.common.annotation.ApiResult;
import com.jagt.employ.user.hello.dto.HelloDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "学生信息API", tags = {"学生信息API"})
@RestController
@RequestMapping(value = "/api/user/v1")
public class HelloApi {

	@Autowired
    private HelloService helloService;

    /**
     * 测试服务
     * @return
     */
    @ApiResult
    @ApiOperation(value = "测试联通性",notes="请求接口前可调用该接口测试接口是否活着")
    @GetMapping(value = "/isalive")
    public String isAlive(){
        return "ok";
    }


    /**
     * 调用自己服务
     * @param name
     * @return
     */
	@ApiResult // sgn: 加上此注解，自动封装返回对象
	@ApiOperation(value ="设置值")  // sgn: 加上此注解，开启打印日志
    @PostMapping(value = "/set")
    public String sayHello(@ApiParam(name="name",value = "姓名",required=false, defaultValue = "hello") String name,
                           @ApiParam(name="value",value = "账号",required=false, defaultValue = "developer") String value){
		name = name.trim();// sgn: 对传入参数进行简单的加工
		helloService.set(name, value);// sgn: 调用service层接口，业务逻辑都写在service层
        return "ok";
    }


    /**
     * 调用自己服务
     * @param name
     * @return
     */
    @ApiResult
    @ApiOperation(value ="获取值")
    @GetMapping(value = "/get")
    public HelloDTO sayHello(@ApiParam(name="name",value = "姓名",required=false, defaultValue = "hello") String name){
        return helloService.get(name);
    }
}
