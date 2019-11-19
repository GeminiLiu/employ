
# 技术选型
    前端：vue
    后端：jdk8+springboot
    缓存：caffeine
    模板：freemarker
    缓存：redis
    数据库：MySQL
    持久层：写：jpa，读：jooq
    连接池：hikari
    解析excel：easyexcel
    JSON：jackson
    解析XML：XStream+dom4j
    消息：RabbitMQ
    构建：gradle
    
    对于services下的业务服务：
    领域模型采用贫血模型（非失血模型）
    分层采用ddd+cqrs模式
    
    ......
---------------------------

## 项目结构:

```
├─employ
│  │  
│  ├─employ-auth--------------------------------鉴权服务
│  │  
│  ├─employ-gateway-----------------------------网关服务
│  │  
│  ├─employ-commons-----------------------------通用模块层
│  |  ├─employ-common---------------------------微服务启动核心模块
│  |  ├─...
│  │  
│  ├─employ-services----------------------------业务服务层
│  |  ├─employ-boot-----------------------------微服务启动核心模块
│  |  ├─employ-enterprise-----------------------企业服务
│  |  |  ├─employ-enterprise-application--------企业服务应用层模块
│  |  |  ├─employ-enterprise-domain-------------企业服务领域层模块
│  |  |  ├─employ-enterprise-infra--------------企业服务基础设施模块
│  |  |  ├─employ-enterprise-ui-----------------企业服务展示层模块
│  |  ├─employ-interview------------------------面试服务
│  |  |  ├─employ-interview-application---------面试服务应用层模块
│  |  |  ├─employ-interview-domain--------------面试服务领域层模块
│  |  |  ├─employ-interview-infra---------------面试服务基础设施模块
│  |  |  ├─employ-interview-ui------------------面试服务展示层模块
│  |  ├─employ-student--------------------------学生服务
│  |  |  ├─employ-student-application-----------学生服务应用层模块
│  |  |  ├─employ-student-domain----------------学生服务领域层模块
│  |  |  ├─employ-student-infra-----------------学生服务基础设施模块
│  |  |  ├─employ-student-ui--------------------学生服务展示层模块
│  │
│  │-...
```

## 环境须知：
- JDK8
- Gradle4.6+
- IDEA`lombok插件` 并设置Setting - Build - Compiler - AnnotationProcessors - 开启右侧勾选

## 运行步骤: 
- 1、以gradle方式导入工程
- 2、刷新gradle，自动下载jar包
- 3、配置都已设置好，直接在对应模块下开发

## 版本说明

### Version: 1.0.0
    Date: 20191027
    Modify By:  gotanks
### Desc:  
    1、初始化工程