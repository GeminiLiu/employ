package com.jagt.employ.student.resume.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * @description: 开始结束时间
 * @author: gemini.liu
 * @create: 2019-12-11 11:53
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StartEndTimeV {

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startTime;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endTime;

}
