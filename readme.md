
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
│  |  ├─employ-college--------------------------院校服务
│  |  ├─employ-enterprise-----------------------企业服务
│  |  ├─employ-interview------------------------面试服务
│  |  ├─employ-student--------------------------学生服务
│  |  ├─employ-recruitment----------------------招聘会服务
│  |  ├─employ-user-----------------------------用户服务
│  |  ├─employ-video----------------------------视频服务
│  │
│  │-...
```

## 分层说明:

```
├───────
│  │  
│  ├─ui-----------------------------展示层：最外层，供外界用户访问或接口调用，调用app层
│  |  ├─api---------------------------对外接口（XxxApi, @RestController）
│  |  ├─controller--------------------页面跳转（XxxController, @RestController）
│  │  
│  ├─app----------------------------应用层：调度命令，组装对象，调用domain层（写入）或query层（读取）
│  |  ├─service-----------------------应用服务层（XxxService）
│  |  ├──impl---------------------------应用服务实现类（XxxServiceImpl, extends ServiceImpl）
│  |  ├─cmd---------------------------写入命令（XxxCmd, implements Command<>）
│  |  ├─qry---------------------------查询命令（XxxQry, implements Command<>）
│  |  ├─dto---------------------------数据传输对象（XxxDTO）
│  |  ├─assembler---------------------组装器（XxxAssembler）
│  │  
│  ├─domain-------------------------领域层：读写分离-写入，执行增删改操作，通过jpa操作领域对象
│  |  ├─service-----------------------领域服务层（XxxDomainService, extends DomainServiceImpl）
│  |  ├─repository--------------------数据仓库（XxxRepository）
│  |  ├─entity------------------------实体（XxxE, extends BaseEntity）
│  |  ├─vo----------------------------值对象（XxxV）
│  |  ├─event-------------------------领域事件（XxxEvent）
│  │  
│  ├─query--------------------------查询层：读写分离-读取，执行查询操作，通过jooq查询
│  |  ├─service-----------------------查询服务层（XxxQueryService, extends QueryServiceImpl）
│  |  ├─model-------------------------查询对象（XxxM）
│  |
│  ├─infra--------------------------基础设施层：通用的工具类，供其他各层调用
│  |  ├─command-----------------------命令模式公共接口类
│  |  ├─config------------------------springboot配置类
│  |  ├─constants---------------------常量类
│  |  ├─enums-------------------------枚举类
│  |  ├─util--------------------------工具类
│  |  ├─......
│  │
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