package com.jagt.employ.common.aspect;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspect {
	@Autowired
	private HttpServletRequest request;

//    private final static String SPACE = "\r\n                                                                                                     ";

    /**
     * 使用ThreadLocal创建对象，防止出现线程安全问题
     */
    private static final ThreadLocal<Long> START_TIME = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return 0L;
        }
    };
    
	/**
	 * 定义请求日志切入点
	 */
	@Pointcut(value = "@annotation(operation)")
	public void serviceStatistics(ApiOperation operation) {

	}
	
	/**
	 * 前置通知
	 * @param joinPoint
	 * @param operation
	 */
	@Before(value = "serviceStatistics(operation)")
	private void doBefore(JoinPoint joinPoint, ApiOperation operation) {
	    START_TIME.set(System.currentTimeMillis());
		String classPath = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info(">>>  [{}] ({}) {}.{}{}",
				operation.value(), 
				request.getRequestURL(),
				classPath, 
				methodName,
				args
				);
	}
	
	/**
	 * 返回通知
	 * @param operation
	 * @param returnValue
	 */
	@AfterReturning(value = "serviceStatistics(operation)", returning = "returnValue")
	private void doAfterReturning(ApiOperation operation, Object returnValue) {
	    long duration = System.currentTimeMillis() - START_TIME.get();
		log.info("<<<  [{}] ({}ms) {}", 
				operation.value(), 
				duration,
				returnValue);
	}
	
	/**
	 * 异常通知
	 * @param operation
	 * @param e
	 */
	@AfterThrowing(value = "serviceStatistics(operation)", throwing = "e")
	private void doAfterThrowing(ApiOperation operation, Throwable e) {
        long duration = System.currentTimeMillis() - START_TIME.get();
		log.warn("!!!  [{}] ({}ms) {}",  
				operation.value(), 
				duration, 
				e);
	}
}
