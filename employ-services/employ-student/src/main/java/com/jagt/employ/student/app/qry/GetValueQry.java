package com.jagt.employ.student.app.qry;

import com.jagt.employ.common.command.Command;
import com.jagt.employ.common.command.Executor;
import com.jagt.employ.student.query.service.HelloQueryService;

public class GetValueQry implements Command<String> {

    private String name;

    public GetValueQry(String name){
        this.name = name;
    }

    @Override
    public String execute(Executor executor) {
        HelloQueryService receiver = executor.getReceiver(HelloQueryService.class);
        return receiver.getValue(name);
    }
}