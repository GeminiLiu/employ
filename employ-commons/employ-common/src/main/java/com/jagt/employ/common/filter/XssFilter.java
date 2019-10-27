package com.jagt.employ.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.jagt.employ.common.tools.Jackson_;

@Slf4j
@WebFilter(filterName = "XssFilter",urlPatterns = "/*")
public class XssFilter implements Filter {

    @Value("${ms.filter.xss:false}")
    private boolean FILTER_XSS;
    
    @Value("${ms.filter.xss.debug:false}")
    private boolean FILTER_XSS_DEBUG;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if(FILTER_XSS) {
            if(FILTER_XSS_DEBUG){
                log.debug("before xss filter paramter:{}", Jackson_.toJson(request.getParameterMap()));
            }
            XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
            if(FILTER_XSS_DEBUG){
                log.debug("after xss filter paramter:{}", Jackson_.toJson(xssRequest.getParameterMap()));
            }
            chain.doFilter(xssRequest, response);
        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
