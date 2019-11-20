package com.jagt.employ.enterprise.infra.enums;

import com.jagt.employ.common.exception.ExceptionInfo;

public enum E {
	E001(1001, "value为空"),
	E002(1002, "222222222222");
	
	private ExceptionInfo exceptionInfo;
	private E(Integer code, String msg) {
		this.exceptionInfo = new ExceptionInfo(code, msg);
	}

	public ExceptionInfo info() {
		return exceptionInfo;
	}
	public ExceptionInfo info(Exception e) {
		exceptionInfo.setException(e);
		return exceptionInfo;
	}
}
