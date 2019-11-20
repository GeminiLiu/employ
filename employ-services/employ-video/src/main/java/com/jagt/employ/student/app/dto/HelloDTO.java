package com.jagt.employ.vidoe.app.dto;

import lombok.Data;
/**
 * DTO（Data Transfer Object）
 * 数据传输对象
 *
 * 用于application层与ui层的交互
 *
 * 在DTO层可以使用基础设施层的validation组件完成入参格式校验；
 * 
 * @author gotanks
 *
 */
@Data
public class HelloDTO {
	public String name;
	public String msg;
}
