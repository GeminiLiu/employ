package com.jagt.employ.student.resume.domain.entity;

import com.jagt.employ.common.entity.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 技能/语言
 * @author: gemini.liu
 * @create: 2019-12-11 15:18
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VI_ST_RESUME_SKILL")
public class StudentResumeSkill extends BaseTimeEntity {

    /**
     * 技能/语言名称
     */
    @Column(length = 50)
    private String skillName;

    /**
     * 技能/语言程度
     */
    @Column(length = 200)
    private String skillDegree;
}
