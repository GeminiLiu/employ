package com.jagt.employ.student.resume.domain.entity;

import com.jagt.employ.common.entity.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 求职目标
 * @author: gemini.liu
 * @create: 2019-12-11 11:22
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VI_ST_RESUME_TARGET")
public class StudentResumeTarget extends BaseTimeEntity {

    /**
     * 简历ID
     */
    @Column(length=20,nullable = false)
    private String resumeId;

    /**
     * 工作类型
     */
    @Column(length=50)
    private String workTypes;

    /**
     * 期望月薪
     */
    @Column(length=100)
    private String expectedSalary;

    /**
     * 意向职能
     */
    @Column(length=100)
    private String jobFunction;

    /**
     * 意向行业
     */
    @Column(length=100)
    private String jobTrade;

}
