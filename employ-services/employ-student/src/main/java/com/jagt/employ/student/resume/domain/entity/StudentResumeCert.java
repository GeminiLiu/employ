package com.jagt.employ.student.resume.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jagt.employ.common.entity.BaseTimeEntity;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @description: 专业证书
 * @author: gemini.liu
 * @create: 2019-12-11 15:11
 **/
public class StudentResumeCert extends BaseTimeEntity {

    /**
     * 证书名称
     */
    @Column(length = 50)
    private String certName;

    /**
     * 证书获取时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime certTime;

    /**
     * 证书成绩
     */
    @Column(precision = 6,scale = 2)
    private BigDecimal certScore;
}
