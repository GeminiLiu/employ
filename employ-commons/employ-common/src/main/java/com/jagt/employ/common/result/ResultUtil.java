package com.jagt.employ.common.result;

import com.jagt.employ.common.exception.ExceptionInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * 返回统一的数据格式
 */
public class ResultUtil {

	private final static Integer SUCCESS_CODE = 0;
    private final static String SUCCESS_MSG = "success";
    protected final static String DATA_COUNT = "data-count";

	public static Result<String> success(String object) {
		Result<String> result = new Result<>();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        result.setData(object);
        return result;
    }
	
	public static Result<Object> success(Object object) {
		Result<Object> result = new Result<>();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        result.setData(object);
        return result;
    }

	public static Result<String> success() {
        return success(null);
    }

	public static Result<Object> error(Integer code, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

	public static Result<ExceptionInfo> error(ExceptionInfo e) {
		Result<ExceptionInfo> result = new Result<ExceptionInfo>();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
	}

	public static void setCount(HttpServletResponse response, Integer size){
        response.setHeader(DATA_COUNT, size+"");
    }
}
