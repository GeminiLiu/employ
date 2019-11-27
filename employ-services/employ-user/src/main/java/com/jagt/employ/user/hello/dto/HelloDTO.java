package com.jagt.employ.user.hello.dto;

import com.jagt.employ.user.infra.model.tables.Hello;
import lombok.Builder;
import lombok.Data;
import org.jooq.Record;

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
@Builder
public class HelloDTO {
	private String name;
	private String value;

	public static HelloDTO build(Record record){
		//builder构造器
		return HelloDTO.builder()
				.name(record.get("name").toString())
				.value(record.get("msg").toString())
				.build();
	}
}
