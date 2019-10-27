package com.jagt.employ.enterprise.entity;

import com.jagt.employ.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entity 实体对象
 * 
 * 有唯一标识，可变的业务实体对象，它有着自己的生命周期。
 * 【重点】一定要采用不依赖repository的充血模型
 * 设计时要考虑聚合，不需要每个实体都有对应的仓库
 * 
 * @author gotanks
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
//@Table(name = "HELLO")
public class Hello extends BaseEntity{
	/**
	 * 字段
	 */
	@Column
	private String name;

	@Column
	private String msg;

	/**
	 * 生成msg
	 * @return
	 */
	public void buildMsg(String prop) {
		StringBuilder result = new StringBuilder();
		result.append("hello ")
			.append(this.name)
			.append("!! 由于读取缓存，相同name时间戳不变。");
		if(prop!=null){
			result.append("配置属性：").append(prop);
		}
		this.setMsg(result.toString());
	}
}
