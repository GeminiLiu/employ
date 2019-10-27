
# 技术选型
    前端：vue
    后端：jdk8+springboot
    缓存：caffeine
    模板：freemarker
    连接池：hikari
    解析excel：easyexcel
    解析JSON：jackson
    解析XML：XStream+dom4j
    构建：gradle
    
    对于services下的业务服务：
    领域模型采用贫血模型（非失血模型）
    分层采用ddd+cqrs模式
    读操作：jooq
    写操作：jpa
    
    ......
---------------------------
## 服务介绍

项目名称	| 编号 | 名称	| 说明	
------------- | ------------- | ------------------------- | -------------
employ-auth	| employ-auth | 认证服务	| 无	
employ-gateway | employ-gateway	| 服务网关	| 基于Gateway构建服务网关，并对服务进行负载，前只实现静态路由
employ-commons/employ-common | 无	| 通用工具	| 包含一些通用的util和类，被services包下的服务引用
employ-services/employ-boot | employ-biz	| 启动服务	| springboot启动主服务
employ-services/employ-enterprise | 无	| 企业服务	| 企业域子模块
employ-services/employ-student | 无	| 学生服务	| 学生域子模块
employ-services/employ-interview | 无 | 面试服务 | 面试域子模块

# 版本说明

## Version: 1.0.0
    Date: 20191027
    Modify By:  gotanks
#### Desc:  
    1、初始化工程