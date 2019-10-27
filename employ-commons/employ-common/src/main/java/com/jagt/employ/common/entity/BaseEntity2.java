package com.jagt.employ.common.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 基类
 * @author gotanks
 *
 */
@Data
@MappedSuperclass
@Deprecated
public class BaseEntity2 implements Serializable {

	private static final long serialVersionUID = -3087542272197406731L;
	/**
	 * uuid主键
	 */
	@Id
	@Column(length = 50)
	@GenericGenerator(name="system-uuid", strategy="uuid2")
//	@GenericGenerator(name="system-uuid", strategy="com.jagt.employ.common.generator.SnowflakeGenerator")
	@GeneratedValue(generator="system-uuid")
	private String id;

	/**
	 * 乐观锁
	 */
	@Column
	@Version
	private Long version;
}