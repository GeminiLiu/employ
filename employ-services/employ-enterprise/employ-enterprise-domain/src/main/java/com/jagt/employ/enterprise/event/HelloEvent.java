package com.jagt.employ.enterprise.event;

import javax.persistence.Column;

import lombok.Data;

/**
 * VO （value object） 值对象
 * 
 * 领域值对象。可以没有唯一性业务标识，且一旦定义，他是不可变的，它通常是短暂的。
 * 
 * @author gotanks
 *
 */
@Data
public class HelloEvent{
	
	/**
	 * 字段
	 */
	@Column
	private String field;
	
}
