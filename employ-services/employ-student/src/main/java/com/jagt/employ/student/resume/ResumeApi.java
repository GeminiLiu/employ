package com.jagt.employ.student.resume;

import com.jagt.employ.common.annotation.ApiResult;
import com.jagt.employ.student.resume.dto.ResumeBaseDto;
import com.jagt.employ.student.resume.dto.ResumeTargetDto;
import com.jagt.employ.student.resume.dto.ResumeWorkDto;
import com.jagt.employ.student.resume.vo.ResumeVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @description: 学生简历API
 * @author: gemini.liu
 * @create: 2019-12-11 17:10
 **/
@Api(value = "学生简历API", tags = {"学生简历API"})
@RestController
@RequestMapping(value = "/api/resume",consumes = "application/json",produces="application/json")
public class ResumeApi {

    @ApiResult
    @ApiOperation(value = "测试联通性",notes="请求接口前可调用该接口测试接口是否活着")
    @RequestMapping(value = "/isalive",method = RequestMethod.GET)
    public String isAlive(){
        return "ok";
    }

    @ApiResult
    @ApiOperation(value="获取简历",notes = "根据简历ID获取简历信息")
    @RequestMapping(value = "/resume/{id}",method = RequestMethod.GET)
    public ResumeVo getResume(@ApiParam(name="id",value = "简历ID",required=true)@PathVariable Long id){
        return new ResumeVo(10086010086L, LocalDateTime.now());
    }

    @ApiResult
    @ApiOperation(value="修改简历",notes = "根据简历ID修改简历信息")
    @RequestMapping(value = "/resume/{id}",method = RequestMethod.PUT)
    public String modifyResumeBaseInfo(@ApiParam(name="id",value = "简历ID",required=true)@PathVariable Long id, @ModelAttribute ResumeBaseDto resumeCreate){
        return "10086010086";
    }

    @ApiResult
    @ApiOperation(value="创建简历保存简历基本信息",notes = "保存简历第一步")
    @RequestMapping(value = "/resume/base",method = RequestMethod.POST)
    public String createResumeBaseInfo(@ModelAttribute ResumeBaseDto resumeBase){
        return "10086010086";
    }

    @ApiResult
    @ApiOperation(value="创建简历保存工作经历",notes = "保存简历第二步")
    @RequestMapping(value = "/resume/work",method = RequestMethod.POST)
    public String createResumeWorkInfo(@ModelAttribute ResumeWorkDto resumeWork){
        return "10086010086";
    }

    @ApiResult
    @ApiOperation(value="创建简历保存求职目标",notes = "保存简历第三步")
    @RequestMapping(value = "/resume/target",method = RequestMethod.POST)
    public String createResumeTargetInfo(@ModelAttribute ResumeTargetDto resumeCreate){
        return "10086010086";
    }

}
