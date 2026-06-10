# Z-Admin

基于 Spring Boot 3 的企业级后台管理系统开发脚手架。

## 项目简介

**项目宗旨：统一开发规范，简化开发成本。**

Z-Admin 是一个开箱即用的 Java 后台管理系统开发脚手架，旨在为团队提供标准化的开发框架和最佳实践，避免重复造轮子，让开发者聚焦于业务逻辑。

**核心理念：**

- **统一规范**：统一 RESTful 风格、参数校验、对象转换、代码生成、异常处理等开发规范
- **快速上手**：内置用户管理、角色权限、菜单管理等通用模块，新团队成员可快速接入
- **工程化实践**：主从数据库读写分离、JWT 无状态认证、代码生成器、接口文档自动生成

项目提供用户管理、角色权限管理等基础功能，采用主从数据库架构，集成 JWT + Spring Security 实现无状态登录认证。

## 配套前端项目

本后端项目需配合前端 **vue-z-admin** 使用，前后端分离架构。

**vue-z-admin** 是一个开箱即用的中后台前端解决方案，基于 `vue-element-admin` 模板构建，内置了登录鉴权、动态路由、权限控制等常见管理系统功能。

**前端技术栈：**

- Vue 2.6 + Vue Router 3 + Vuex 3
- Element UI 2.13
- Axios 0.18
- Sass + svg-sprite-loader
- Jest 单元测试

| 项目 | 技术栈 | 说明 |
|------|--------|------|
| **z-admin** | Spring Boot 3 + Java 21 | 后端服务，提供 RESTful API |
| **vue-z-admin** | Vue 2.6 + Element UI 2.13 | 前端项目，内置登录鉴权、动态路由、权限控制 |

**前后端协作：**

```
┌─────────────────┐          ┌─────────────────┐
│   vue-z-admin  │  HTTP  │     z-admin     │
│  (Vue 2.6 前端) │ ────────▶ │ (Spring Boot 后端) │
│                 │          │                 │
│  - 登录鉴权      │   JSON   │  - RESTful API   │
│  - 动态路由      │ ◀─────── │  - 数据持久化    │
│  - 权限控制      │          │  - 权限管理      │
│  - 页面交互      │          │                 │
└─────────────────┘          └─────────────────┘
```

**前端项目地址：** https://github.com/tdsay-cn/vue-z-admin

## 技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 21 | 开发语言 |
| Spring Boot | 3.4.12 | 应用框架 |
| Spring Security | 3.4.12 | 安全认证框架 |
| MyBatis-Plus | 3.5.14 | ORM 框架 |
| Dynamic Datasource | 4.5.0 | 多数据源支持 |
| MySQL | - | 主从数据库 |
| Redis | - | 缓存服务 |
| JWT | 0.12.6 | 令牌生成/解析 |
| Lombok | 1.18.34 | 简化 Java 代码 |
| FastJSON2 | 2.0.52 | JSON 处理 |
| EasyExcel | 4.0.3 | Excel 导入导出 |
| MapStruct | 1.5.5.Final | 对象映射（编译期） |
| Orika | 1.5.4 | 对象映射（运行时） |
| Smart-Doc | 3.0.7 | 接口文档自动生成 |
| FreeMarker | 2.3.34 | 代码生成模板 |

## 项目结构

```
z-admin/
├── src/
│   ├── main/
│   │   ├── java/com/z/admin/
│   │   │   ├── config/              # 配置类
│   │   │   ├── controller/          # 控制层
│   │   │   ├── dao/                 # 数据访问层（Mapper）
│   │   │   ├── entity/              # 实体类
│   │   │   │   ├── convert/         # 对象转换器（MapStruct）
│   │   │   │   ├── dto/             # 数据传输对象
│   │   │   │   ├── enums/           # 枚举类
│   │   │   │   ├── excel/           # Excel 相关
│   │   │   │   ├── form/            # 表单对象
│   │   │   │   ├── param/           # 查询参数
│   │   │   │   ├── po/              # 持久化对象
│   │   │   │   └── vo/              # 视图对象
│   │   │   ├── exception/           # 异常类
│   │   │   ├── scheduled/           # 定时任务/启动加载
│   │   │   ├── security/            # 安全认证
│   │   │   ├── service/             # 业务层
│   │   │   ├── util/                # 工具类
│   │   │   ├── validator/           # 自定义校验器
│   │   │   └── ZAdminApplication.java
│   │   └── resources/
│   │       ├── mybatis/             # Mapper XML
│   │       ├── smartDoc/            # Smart-Doc 配置
│   │       ├── application.yml      # 主配置
│   │       ├── application-dev.yml  # 开发环境配置
│   │       ├── application-test.yml # 测试环境配置
│   │       └── logback-spring.xml   # 日志配置
│   └── test/                        # 测试 & 代码生成器
├── docker/                          # Docker 相关
├── 秘籍/                            # SQL 脚本 & 项目文档
└── pom.xml
```

## 核心功能

- **用户管理**：用户增删改查、密码管理、状态管理
- **角色管理**：角色增删改查、角色权限分配
- **权限管理**：权限树管理、权限级别控制（匿名/登录/权限）
- **登录认证**：JWT + Spring Security 无状态认证
- **多数据源**：主从数据库读写分离（1 主库 + 2 从库）
- **Redis 缓存**：用户信息、权限配置缓存
- **代码生成器**：基于 MyBatis-Plus Generator 的代码自动生成
- **Excel 导入导出**：基于 EasyExcel，支持单元格合并
- **接口文档**：Smart-Doc 自动生成 API 文档

## 快速开始

### 环境要求

- JDK 21+
- Maven 3.8+
- MySQL 5.7+ 或 8.0+
- Redis 6.0+

### 启动步骤

**1. 创建数据库**

在 MySQL 中执行以下 SQL，创建 1 个主库和 2 个从库：

```sql
CREATE DATABASE IF NOT EXISTS z_admin DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS z_admin_slave_1 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS z_admin_slave_2 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

**2. 导入表结构**

导入「秘籍」目录下的 SQL 文件：

| SQL 文件 | 对应数据库 |
|----------|-----------|
| `z_admin.sql` | `z_admin` |
| `z_admin_slave_1.sql` | `z_admin_slave_1` |
| `z_admin_slave_2.sql` | `z_admin_slave_2` |

**3. 启动 Redis**

```bash
redis-server
```

**4. 修改配置（可选）**

如需修改数据库/Redis 连接信息，编辑 `src/main/resources/application-dev.yml`：

```yaml
spring:
  datasource:
    dynamic:
      datasource:
        master:
          url: jdbc:mysql://localhost:3306/z_admin?...
          username: root
          password: root
  data:
    redis:
      host: localhost
      port: 6379
```

**5. 启动服务**

```bash
mvn spring-boot:run
```

或打包后运行：

```bash
mvn clean package
java -jar target/z-admin-0.0.1-SNAPSHOT.jar
```

服务启动后访问：`http://localhost:8888/admin`

## 权限模型

系统采用**「权限为核心、角色为桥梁」**的鉴权模型：

```
┌──────────┐      ┌──────────┐      ┌──────────────┐
│   用户   │─────▶│   角色   │─────▶│   权限集合   │
└──────────┘      └──────────┘      └──────────────┘
     │                                               │
     │                  直接分配权限                   │
     └───────────────────────────────────────────────┘

最终用户权限 = 用户直接分配的权限 ∪ 所属角色包含的权限
```

- **前端**：页面按钮、菜单的显隐均通过判断用户是否拥有对应的权限标识来控制
- **后端**：接口访问控制同样通过判断用户是否拥有接口绑定的权限标识来控制
- **角色**：不直接参与鉴权判断，仅作为「权限集合」的载体存在

## 接口文档

项目使用 Smart-Doc 自动生成接口文档。

**生成文档：**

```bash
mvn smart-doc:html
```

**配置文件：** `src/main/resources/smartDoc/smart-doc.json`

## 代码生成

代码生成器位于 `src/test/java/com/z/admin/generation/CodeGenerationTest.java`。

运行步骤：

1. 根据实际数据库连接信息修改 `MysqlPropertyMaster`、`MysqlPropertySlave1`、`MysqlPropertySlave2`
2. 运行对应的生成方法 `codeGenerationMaster()`、`codeGenerationSlave1()`、`codeGenerationSlave2()`
3. 自动生成 PO、Mapper、Mapper XML、Service、ServiceImpl

## 多环境配置

| 环境 | Profile | 说明 |
|------|---------|------|
| 开发 | dev | 默认启用 |
| 测试 | test | 测试环境 |
| 预发布 | uat | 预发布环境 |
| 生产 | prod | 生产环境 |

切换环境：修改 `application.yml` 中的 `spring.profiles.active`，或在编译时指定：

```bash
mvn clean package -P test
```

## 统一返回值

```json
{
  "code": 0,
  "msg": "success",
  "data": {}
}
```

| 错误码 | 说明 |
|--------|------|
| 0 | 操作成功 |
| 500 | 服务器错误 |
| 40100 | 用户名或密码错误 |
| 40101 | 认证失败 |
| 40102 | 用户已禁用 |
| 50000 | 重复操作 |

## Docker 部署

项目提供 `docker/Dockerfile` 和 `docker-compose.yml`，可快速容器化部署。

## License

本项目基于 [Apache License 2.0](LICENSE) 协议开源。
