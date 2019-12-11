package com.jagt.employ.student.resume.domain.entity;

import com.jagt.employ.common.entity.BaseTimeEntity;
import com.jagt.employ.student.resume.domain.vo.StartEndTimeV;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 项目/实践经验
 * @author: gemini.liu
 * @create: 2019-12-11 14:41
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VI_ST_RESUME_PROJ")
public class StudentResumeProj extends BaseTimeEntity {

    /**
     * 项目名称
     */
    @Column(length = 50)
    private String projectName;

    /**
     * 项目时间
     */
    @Embedded
    private StartEndTimeV projectTime;

    /**
     * 项目/时间描述
     */
    @Column(length = 1000)
    private String projectDescription;

}
