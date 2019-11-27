package com.jagt.employ.user.hello.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VO （value object） 值对象
 * 
 * 领域值对象。可以没有唯一性业务标识，且一旦定义，他是不可变的，它通常是短暂的。
 * 
 * @author gotanks
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class HelloV {
	
	/**
	 * 此字段会追加到引用此VO的entity实体表中
	 */
	@Column
	private String field;
	
}
