package com.jagt.employ.student.resume.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 简历保存成功vo
 * @author: gemini.liu
 * @create: 2019-12-12 15:03
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="简历新建返回",description="简历新建返回")
@AllArgsConstructor
public class ResumeVo {

    @ApiModelProperty(value="事件ID",required = true,example = "100201")
    private Long resumeId;

    @ApiModelProperty(value="创建时间",required = true,example = "2019-01-01 12:22:01")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
