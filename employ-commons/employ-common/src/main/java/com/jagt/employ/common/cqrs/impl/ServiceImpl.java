package com.jagt.employ.common.cqrs.impl;

import com.jagt.employ.common.cqrs.executor.CommandExecutor;
import com.jagt.employ.common.cqrs.executor.QueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl {

    @Autowired
    protected CommandExecutor commandExecutor;

    @Autowired
    protected QueryExecutor queryExecutor;

}
