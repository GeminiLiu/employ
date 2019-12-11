package com.jagt.employ.student.resume.domain.entity;

import com.jagt.employ.common.entity.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 简历标签
 * @author: gemini.liu
 * @create: 2019-12-11 10:34
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VI_ST_RESUME_TAG")
public class StudentResumeTag extends BaseTimeEntity {

    /**
     * 简历关联ID
     */
    @Column(length=20,nullable = false)
    private Long resumeId;

    /**
     * 标签名称
     */
    @Column(length=50,nullable = false)
    private String tagValue;


}
