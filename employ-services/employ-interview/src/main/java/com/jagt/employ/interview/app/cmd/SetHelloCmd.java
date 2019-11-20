package com.jagt.employ.interview.app.cmd;

import com.jagt.employ.common.command.Command;
import com.jagt.employ.common.command.Executor;
import com.jagt.employ.interview.domain.service.HelloDomainService;

public class SetHelloCmd implements Command<Void> {
    private String name;
    private String value;

    public SetHelloCmd(String name, String value){
        this.name = name;
        this.value = value;
    }

    @Override
    public Void execute(Executor executor) {
        HelloDomainService receiver = executor.getReceiver(HelloDomainService.class);
        receiver.setValue(name, value);
        return null;
    }

}
