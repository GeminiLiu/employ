package com.jagt.employ.student.resume.domain.entity;

import com.jagt.employ.common.entity.BaseTimeEntity;
import com.jagt.employ.student.resume.domain.vo.StudyMajorV;
import com.jagt.employ.student.resume.domain.vo.StudySchoolV;
import com.jagt.employ.student.resume.domain.vo.StartEndTimeV;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 教育经历
 * @author: gemini.liu
 * @create: 2019-12-11 11:35
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VI_ST_RESUME_EDU")
public class StudentResumeEdu extends BaseTimeEntity {

    /**
     * 简历ID
     */
    @Column(length = 20,nullable = false)
    private Long resumeId;

    /**
     * 就读学校
     */
    @Embedded
    private StudySchoolV studySchool;

    /**
     * 就读时间
     */
    @Embedded
    private StartEndTimeV studyTime;

    /**
     * 学习专业
     */
    @Embedded
    private StudyMajorV studyMajor;

    /**
     * 是否留学:1=留学,0=未留学
     */
    @Column(length=2)
    private int studyAbroad;

    /**
     * 是否最高学历:1=是,0=否
     */
    @Column(length=2)
    private int highestDegree;


}




