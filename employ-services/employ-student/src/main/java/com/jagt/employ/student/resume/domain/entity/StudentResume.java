package com.jagt.employ.student.resume.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jagt.employ.common.entity.BaseTimeEntity;
import com.jagt.employ.student.resume.domain.vo.AddressV;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @description: 学生简历实体类
 * @author: gemini.liu
 * @create: 2019-12-10 17:54
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VI_ST_RESUME")
public class StudentResume extends BaseTimeEntity {

    /**
     * 姓名
     */
    @Column(length=50,nullable = false)
    private String name;

    @Column(length = 200)
    private String headImgPath;

    /**
     * 性别:1=男,2=女
     */
    @Column(length = 2)
    private int sex = 1;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthday;

    @Embedded
    private AddressV currentAddress;

    @Column(length=20)
    private String phone;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startWorkTime;

    @Column(length=50)
    private String email;

    /**
     * 籍贯
     */
    @Column(length=50)
    private String nativePlace;

    /**
     * 标签
     */
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="resumeId")
    private Set<StudentResumeTag> tags;

    /**
     * 求职目标
     */
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="resumeId")
    private Set<StudentResumeTarget> targets;

}
