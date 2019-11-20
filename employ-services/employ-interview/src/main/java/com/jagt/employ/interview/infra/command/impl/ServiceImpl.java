package com.jagt.employ.interview.infra.command.impl;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl {

    @Autowired
    protected CommandExecutor commandExecutor;

    @Autowired
    protected QueryExecutor queryExecutor;

}
