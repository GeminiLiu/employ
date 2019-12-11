package com.jagt.employ.student.resume.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @description: 学习专业值
 * @author: gemini.liu
 * @create: 2019-12-11 12:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudyMajorV {

    /**
     * 一级专业
     */
    @Column(length = 100)
    private String majorLv1;

    /**
     * 二级专业
     */
    @Column(length = 100)
    private String majorLv2;

    /**
     * 专业描述
     */
    @Column(length=500)
    private String majorInstructions;
}
