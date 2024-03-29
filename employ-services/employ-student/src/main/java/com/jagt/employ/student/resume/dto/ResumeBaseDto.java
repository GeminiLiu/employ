package com.jagt.employ.student.resume.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 简历基本信息dto
 * @author: gemini.liu
 * @create: 2019-12-12 12:26
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value="简历-基本信息",description="简历-基本信息")
public class ResumeBaseDto {

    @ApiModelProperty(value="姓名",required = true,example = "gemini")
    private String name;
    @ApiModelProperty(value="所在地,字段数组分别为省、市",required = true,example="[北京,北京]")
    private List<String> city;
    @ApiModelProperty(value="生日",required = true,example = "2019-09-01")
    private String birthday;
    @ApiModelProperty(value="邮箱",required = true,example = "support@shimianpower.com")
    private String email;
    @ApiModelProperty(value="毕业学校",required = true,example = "麻省理工学院")
    private String college;
    @ApiModelProperty(value="学习时间",required = true,example = "[2017-09-01,2011-06-30]")
    private List<String> studyTime;
    @ApiModelProperty(value="学历",required = true,example = "本科")
    private String degree;
}
