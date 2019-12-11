package com.jagt.employ.student.resume.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @description: 学习学校信息
 * @author: gemini.liu
 * @create: 2019-12-11 12:34
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudySchoolV {

    /**
     * 学校编号
     */
    @Column(length=50)
    private String schoolCode;

    /**
     * 学校名称
     */
    @Column(length=100)
    private String schoolName;

}
