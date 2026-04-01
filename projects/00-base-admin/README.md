# 00-base-admin

`00-base-admin` 是当前模板工厂的基础底座项目。

## 项目定位

它用于提供统一的管理端起点，包括：

- 登录 / 登出
- JWT + RBAC 基线
- 用户 / 角色 / 菜单
- 仪表盘
- 通用 CRUD 模式
- 本地 H2 快速验证路径
- MySQL 初始化与 profile 验证路径

## 当前实现范围

### 后端

- Spring Boot 3
- Java 17 目标版本
- MyBatis-Plus
- 统一响应结构
- 全局异常处理
- JWT 认证骨架
- 仪表盘接口
- 系统管理接口
- 通知 CRUD 示例

### 前端

- Vue 3 + TypeScript + Vite
- Element Plus 管理端壳层
- Pinia 认证状态管理
- Vue Router 保护路由
- 登录页
- 仪表盘
- 用户 / 角色 / 菜单页面
- 通知 CRUD 页面

## 当前目录结构

```text
projects/00-base-admin/
├─ backend/
├─ frontend/
└─ sql/
   └─ mysql/
```

## 启动方式

### 后端

```powershell
cd D:\Projectexample\projects\00-base-admin\backend
mvn -q -DskipTests package
mvn spring-boot:run
```

默认本地快速启动使用 H2 文件数据库。

可选 MySQL profile 验证：

```powershell
$env:MYSQL_HOST='localhost'
$env:MYSQL_PORT='3306'
$env:MYSQL_USERNAME='root'
$env:MYSQL_PASSWORD='123456'
$env:SPRING_PROFILES_ACTIVE='mysql'
mvn -q test
```

### 前端

```powershell
cd D:\Projectexample\projects\00-base-admin\frontend
npm.cmd install
npm.cmd run dev
```

默认地址：

- 前端：`http://localhost:5173`
- 后端：`http://localhost:8080`

## 数据库说明

- MySQL 初始化脚本：`sql/mysql/init.sql`
- 本地数据库命名建议：`designexample_base_admin`
- 已完成本地 MySQL 初始化与连接验证

## 当前验证情况

已验证：

- 后端构建
- 后端测试
- 前端安装
- 前端构建
- MySQL profile 测试上下文

## 已知限制

- 前端生产构建仍有 chunk size 警告
- 尚未补做浏览器/API 端到端烟雾验证

## 后续扩展方向

- 文件上传
- 操作日志
- 图表统计
- 数据字典
- 更细粒度权限模型