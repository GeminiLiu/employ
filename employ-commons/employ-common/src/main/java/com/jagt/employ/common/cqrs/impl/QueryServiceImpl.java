package com.jagt.employ.common.cqrs.impl;


import com.jagt.employ.common.cqrs.QueryService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryServiceImpl implements QueryService {
    @Autowired
    protected DSLContext create;
}
