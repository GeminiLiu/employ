package com.jagt.employ.common.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import java.io.Serializable;

/**
 * 基类
 * @author gotanks
 *
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -2792471937419001854L;
	/**
	 * uuid主键
	 */
	@Id
	@Column(length = 20)
//	@GenericGenerator(name="system-uuid", strategy="uuid2")
	@GenericGenerator(name="system-uuid", strategy="com.jagt.employ.common.generator.SnowflakeGenerator")
	@GeneratedValue(generator="system-uuid")
	private Long id;

	/**
	 * 乐观锁
	 */
	@Column
	@Version
	private Long version;

	/**
	 * 数据状态:1=正常,0=删除
	 */
	@Column
	private int status = 1;
}