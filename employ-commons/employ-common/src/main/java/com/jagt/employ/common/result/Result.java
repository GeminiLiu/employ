package com.jagt.employ.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回统一的数据格式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    //返回编码
    private Integer code;

    //编码描述
    private String msg;

    //编码描述
    private Integer count;
    
    //业务数据
    private T data;
}
