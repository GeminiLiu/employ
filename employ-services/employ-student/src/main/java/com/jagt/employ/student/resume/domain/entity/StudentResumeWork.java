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
 * @description: 实习/工作经历
 * @author: gemini.liu
 * @create: 2019-12-11 14:03
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VI_ST_RESUME_WORK")
public class StudentResumeWork extends BaseTimeEntity {

    /**
     * 公司名称
     */
    @Column(length = 50)
    private String companyName;

    /**
     * 工作时间
     */
    @Embedded
    private StartEndTimeV workTime;

    /**
     * 工作职能
     */
    @Column(length = 50)
    private String jobFunction;

    /**
     * 工作职位
     */
    @Column(length = 50)
    private String jobPosition;

    /**
     * 工作描述
     */
    @Column(length = 3000)
    private String jobDescription;

    /**
     * 部门名称
     */
    @Column(length = 100)
    private String depName;

    /**
     * 行业名称
     */
    @Column(length = 100)
    private String tradeName;

    /**
     * 公司规模
     */
    @Column(length = 100)
    private String companySize;

    /**
     * 公司性质
     */
    @Column(length = 100)
    private String companyNature;

    /**
     * 是否全职:1=全职,0=非全职
     */
    private int fullTime = 1;

}
