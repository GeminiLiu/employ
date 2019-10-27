package com.jagt.employ.common.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ExceptionInfo exceptionInfo;

	public BusinessException(ExceptionInfo exceptionInfo) {
		super(exceptionInfo.getMsg());
		this.exceptionInfo = exceptionInfo;
	}

	public ExceptionInfo getExceptionInfo() {
		return exceptionInfo;
	}

}
