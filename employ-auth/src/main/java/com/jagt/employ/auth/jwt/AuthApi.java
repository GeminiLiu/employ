package com.jagt.employ.auth.jwt;

import com.jagt.employ.auth.jwt.util.JwtHelper;
import com.jagt.employ.common.annotation.ApiResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "权限API", tags = "{票据接口}")
@RestController
@RequestMapping(value = "/api/auth/demo")
public class AuthApi {

    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 测试服务
     * @return
     */
    @ApiResult
    @ApiOperation(value = "测试联通性",notes="请求接口前可调用该接口测试接口是否活着")
    @GetMapping(value = "/isalive")
    public String isAlive(){
        return "ok";
    }

    /**
     * 测试获取token
     * @param audience
     * @return
     */

    @ApiResult
    @ApiOperation(value="测试获取token")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")
    })
    @GetMapping(value = "/getToken")
    public String getToken(@ApiParam(required=false) String audience,@ApiParam(required=false) String issur){
        return jwtHelper.createToken(audience,issur);
    }

    /**
     * 测试解析token
     * @param token
     * @return
     */
    @ApiResult
    @ApiOperation(value="测试解析token")
    @GetMapping(value = "/parseToken")
    public String parseToken(@ApiParam(required=true) String token){
        return jwtHelper.parseToken(token).getIssuer();
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    @ApiResult
    @ApiOperation(value="刷新token")
    @GetMapping(value = "/refreshToken")
    public String refreshToken(@ApiParam(required=true) String token){
        return jwtHelper.refreshToken(jwtHelper.parseToken(token));
    }

}
