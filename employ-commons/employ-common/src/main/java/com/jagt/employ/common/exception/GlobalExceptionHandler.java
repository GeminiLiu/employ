package com.jagt.employ.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jagt.employ.common.result.Result;
import com.jagt.employ.common.result.ResultUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 系统异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)  
    @ResponseBody  
    public Result<ExceptionInfo> handler(Exception e) {
		ExceptionInfo exceptionInfo = new ExceptionInfo(e);
		exceptionInfo.handle();
        return ResultUtil.error(exceptionInfo);
    }

	/**
	 * 业务异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = BusinessException.class)  
    @ResponseBody  
    public Result<ExceptionInfo> handler(BusinessException e) {
		ExceptionInfo exceptionInfo = e.getExceptionInfo();
		exceptionInfo.handle();
		return ResultUtil.error(exceptionInfo);
    }
}
