package com.jagt.employ.student.resume.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @description: 详细地址值类
 * @author: gemini.liu
 * @create: 2019-12-10 18:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LocationV {
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String county;
    @Column
    private String address;

}
