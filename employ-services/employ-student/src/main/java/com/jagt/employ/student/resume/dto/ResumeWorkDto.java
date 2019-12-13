package com.jagt.employ.student.resume.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 简历工作经历dto
 * @author: gemini.liu
 * @create: 2019-12-13 10:27
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="简历-工作经历",description="简历-工作经历")
public class ResumeWorkDto {

    @ApiModelProperty(value="简历ID",required = true)
    private Long resumeId;
    @ApiModelProperty(value="项目/实践-职务",required = true)
    private String projectPosition;
    @ApiModelProperty(value="项目/实践-时间",required = true)
    private List<String> projectTime;
    @ApiModelProperty(value="实习/工作-公司",required = true)
    private String workCompany;
    @ApiModelProperty(value="实习/工作-时间",required = true)
    private List<String> workTime;
    @ApiModelProperty(value="实习/工作-职务",required = true)
    private String workPosition;
    @ApiModelProperty(value="实习/工作-描述")
    private String workDesc;

}
