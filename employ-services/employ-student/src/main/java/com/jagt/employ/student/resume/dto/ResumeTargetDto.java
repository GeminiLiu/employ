package com.jagt.employ.student.resume.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 简历-求职目标dto
 * @author: gemini.liu
 * @create: 2019-12-13 10:42
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="简历-求职目标",description="简历-求职目标")
public class ResumeTargetDto {

    @ApiModelProperty(value="简历ID",required = true)
    private Long resumeId;
    @ApiModelProperty(value="期望工作类型",required = true)
    private String targetType;
    @ApiModelProperty(value="期望工作城市",required = true)
    private List<String>  targetCIty;
    @ApiModelProperty(value="期望月薪",required = true)
    private String targetSalary;
    @ApiModelProperty(value="期望职位",required = true)
    private List<String> targetPosition;
}
