package com.jagt.employ.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 树状实体基类
 * @author gotanks
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@MappedSuperclass
public class BaseTreeEntity extends BaseEntity {

	@Column(length = 20)
	@NotNull
	private Long parentId;

	@Column
	@NotNull
	private Integer lvl;
	
	@Column
	@NotNull
	private String path;
}