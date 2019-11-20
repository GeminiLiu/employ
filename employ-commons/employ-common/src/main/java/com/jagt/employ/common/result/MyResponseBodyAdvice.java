package com.jagt.employ.common.result;

import com.jagt.employ.common.annotation.ApiResult;
import com.jagt.employ.common.tools.Jackson_;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.List;

@SuppressWarnings("rawtypes")
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement annotatedElement = returnType.getAnnotatedElement();
        ApiResult result = AnnotationUtils.findAnnotation(annotatedElement, ApiResult.class);
        return result != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Result<Object> result = ResultUtil.success(body);
        try {
            List<String> strings = response.getHeaders().get(ResultUtil.DATA_COUNT);
            if(strings != null){
                result.setCount(Integer.parseInt(strings.get(0)));
            }
            if(body == null || body instanceof String){
                return Jackson_.toJson(result);
            }
        } catch (Exception e){
            throw new RuntimeException("get data-count error!");
        }
        return result;
    }

}
