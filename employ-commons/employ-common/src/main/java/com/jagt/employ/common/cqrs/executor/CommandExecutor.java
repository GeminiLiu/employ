package com.jagt.employ.common.cqrs.executor;

import com.jagt.employ.common.command.Command;
import com.jagt.employ.common.command.Executor;
import com.jagt.employ.common.command.Receiver;
import com.jagt.employ.common.cqrs.DomainService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommandExecutor implements Executor {

    @Autowired(required = false)
    private Map<String, DomainService> domainServices;


    @Override
    public <R extends Receiver> R getReceiver(Class<R> clazz){
        return (R) domainServices.get(StringUtils.uncapitalize(clazz.getSimpleName()));
    }

    @Override
    public <T> T execute(Command<T> command) {
        return command.execute(this);
    }
}
