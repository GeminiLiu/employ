package com.jagt.employ.student.resume.command;

import com.jagt.employ.common.command.Command;
import com.jagt.employ.common.command.Executor;
import com.jagt.employ.student.resume.dto.HelloDTO;
import com.jagt.employ.student.resume.query.HelloQueryService;
import lombok.AllArgsConstructor;

//查询命令类，实现Command接口，返回泛型
@AllArgsConstructor
public class GetValueQry implements Command<HelloDTO> {
    private String name;

    @Override
    public HelloDTO execute(Executor executor) {
        return executor.getReceiver(HelloQueryService.class).getValue(name);
    }
}
