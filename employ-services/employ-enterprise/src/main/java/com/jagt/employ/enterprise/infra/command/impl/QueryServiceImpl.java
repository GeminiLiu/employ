package com.jagt.employ.enterprise.infra.command.impl;

import com.jagt.employ.enterprise.infra.command.QueryService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryServiceImpl implements QueryService {
    @Autowired
    protected DSLContext dslContext;

}
