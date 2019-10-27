package com.jagt.employ.enterprise.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CQRS 命令层
 *
 * 所有对数据库的写操作写在这里
 * 通过命令模式调用领域层
 * 与query层老死不相往来（不能互相调用）
 *
 * @author gotanks
 *
 */
@Slf4j
@RefreshScope// sgn: 配置中心修改后可以动态刷新
@Service
@Transactional
public class HelloCommand {
}
