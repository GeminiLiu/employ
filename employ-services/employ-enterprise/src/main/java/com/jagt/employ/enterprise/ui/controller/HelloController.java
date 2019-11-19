package com.jagt.employ.enterprise.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller 控制器
 * 
 * 用意在于为远程客户端提供粗粒度的调用接口
 * 它的主要工作就是将一个用户请求委派给一个或多个应用层service进行处理。
 * 可选的工作：校验入参、将入参转为DTO传递给service层
 * 注解@Controller，方法返回DTO并跳转到前台页面
 * 
 * @author gotanks
 *
 */
@Controller
@RequestMapping(value = "/demo", method = RequestMethod.GET)
public class HelloController {
	
    @RequestMapping(value = "/hello")
    public String sayHello(@RequestParam(required=false) String name, 
    		@RequestParam(required=false) String token,
    		Model model){
        System.out.println(token);
        model.addAttribute("name", name);
    	return "hello";
    }
	
}
