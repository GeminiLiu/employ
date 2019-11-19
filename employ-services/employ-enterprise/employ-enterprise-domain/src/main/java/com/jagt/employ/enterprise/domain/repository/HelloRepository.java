package com.jagt.employ.enterprise.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jagt.employ.enterprise.domain.entity.Hello;
/**
 * Repository 仓库
 * 
 * 仓库用户和基础实施的持久化层交互，完成领域对应的增删改查操作
 * 所有对数据库的操作都要在仓库中完成，尽量避免硬写sql，复杂查询可以继承JpaSpecificationExecutor<>实现
 * 
 * @author gotanks
 *
 */
public interface HelloRepository extends JpaRepository<Hello, Long> {

}
