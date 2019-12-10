package com.jagt.employ.student.resume.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jagt.employ.common.entity.BaseTimeEntity;
import com.jagt.employ.student.resume.domain.vo.LocationV;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @description: 学生简历实体类
 * @author: gemini.liu
 * @create: 2019-12-10 17:54
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "STUDENT_RESUME")
public class StudentResume extends BaseTimeEntity {

    /**
     * 姓名
     */
    @Column
    private String name;

    @Column
    private String headImgPath;

    @Column
    private int sex;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthday;

    @Embedded
    private LocationV residentialAddress;

    @Column
    private String phone;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startWorkTime;

    @Column
    private String email;

    /**
     * 籍贯
     */
    @Column
    private String nativePlace;


}
