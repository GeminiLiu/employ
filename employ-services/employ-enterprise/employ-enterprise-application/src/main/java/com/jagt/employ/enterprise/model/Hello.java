package com.jagt.employ.enterprise.model;

import lombok.Data;

/**
 * CQRS 查询对象
 *
 * 用于承载query 层查询出的数据
 * 
 * @author gotanks
 *
 */
@Data
public class Hello {
	public String name;
	public String msg;
}
