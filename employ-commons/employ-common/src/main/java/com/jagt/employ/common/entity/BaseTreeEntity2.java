package com.jagt.employ.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * 树状实体基类
 * @author gotanks
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@MappedSuperclass
@Deprecated
public class BaseTreeEntity2 extends BaseEntity2 {

	@Column(length = 50)
	@NotNull
	private String parentId;

	@Column
	@NotNull
	private Integer lvl;
	
	@Column
	@NotNull
	private String path;
}