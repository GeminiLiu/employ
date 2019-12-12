package com.jagt.employ.student.resume.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @description: 当前居住地值
 * @author: gemini.liu
 * @create: 2019-12-10 18:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddressV {

    /**
     * 省
     */
    @Column(length = 50)
    private String province;

    /**
     * 市
     */
    @Column(length = 50)
    private String city;

    /**
     * 区县
     */
    @Column(length = 50)
    private String county;
}
