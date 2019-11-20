package com.jagt.employ.user.query.model;

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
public class HelloM {
	public String name;
	public String msg;
}
