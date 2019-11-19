package com.jagt.employ.enterprise.infra.command.impl;

import com.jagt.employ.common.command.Command;
import com.jagt.employ.common.command.Executor;
import com.jagt.employ.common.command.Receiver;
import com.jagt.employ.enterprise.infra.command.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QueryExecutor implements Executor {

    @Autowired
    private Map<String, QueryService> queryServices;

    @Override
    public <R extends Receiver> R getReceiver(Class<R> clazz){
        return (R) queryServices.get(clazz.getName());
    }

    @Override
    public <T> T execute(Command<T> command) {
        return command.execute(this);
    }
}
