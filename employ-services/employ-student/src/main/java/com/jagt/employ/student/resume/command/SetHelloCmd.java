package com.jagt.employ.student.resume.command;

import com.jagt.employ.common.command.Command;
import com.jagt.employ.common.command.Executor;
import com.jagt.employ.student.resume.domain.HelloDomainService;
import lombok.AllArgsConstructor;

//命令类，实现Command接口，返回泛型
@AllArgsConstructor
public class SetHelloCmd implements Command<Void> {
    private String name;
    private String value;

    @Override
    public Void execute(Executor executor) {
        HelloDomainService receiver = executor.getReceiver(HelloDomainService.class);
        receiver.setValue(name, value);
        return null;
    }

}
