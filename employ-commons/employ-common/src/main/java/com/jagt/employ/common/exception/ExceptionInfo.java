package com.jagt.employ.common.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionInfo {
	
	private Integer code;
	private String msg;
	private Exception exception;

	private final static int OTHER_CODE = 9999;
	private final static String OTHER_MSG = "系统内部错误";

	public ExceptionInfo(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ExceptionInfo(Exception e) {
		this.code = OTHER_CODE;
		this.msg = OTHER_MSG;
		this.exception = e;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public void handle() {
		if(this.code == OTHER_CODE) {
			log.error("[系统错误] -> {} : {} : {}", code, msg, exception);
		}else {
			log.warn("[业务异常] -> {} : {} : {}", code, msg, exception);
		}
	}
}
