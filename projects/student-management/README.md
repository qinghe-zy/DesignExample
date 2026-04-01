# student-management

$(System.Collections.Hashtable.En) 是基于共享基础底座派生出来的重点项目之一。

## 项目定位

该项目面向 学生管理 场景，目标是在统一管理端底座上承载核心业务流。

## 当前实现范围

- 继承了 00-base-admin 的认证、权限、系统管理与仪表盘基础结构
- 已增加项目业务模块：学生档案、班级与专业、成绩管理、请假/违纪记录
- 已提供后端、前端、数据库脚本与启动说明

## 核心业务模块

学生档案、班级与专业、成绩管理、请假/违纪记录

## 目录结构说明

`	ext
projects/student-management/
├─ backend/
├─ frontend/
├─ sql/
│  ├─ mysql/
│  └─ schema-baseline.sql
└─ docs/
`

## 启动方式

### 后端

`powershell
cd D:\Projectexample\projects\student-management\backend
mvn -q clean -DskipTests package
mvn spring-boot:run
`

### 前端

`powershell
cd D:\Projectexample\projects\student-management\frontend
npm.cmd install
npm.cmd run dev
`

默认地址：

- 后端：http://localhost:8081
- 前端：http://localhost:5181

## 数据库说明

- MySQL 初始化脚本：sql/mysql/init.sql
- 本地数据库：`designexample_student_management`
- 已完成本地数据库初始化与代表数据验证
- 已完成 MySQL profile 下的后端测试上下文验证

## 当前验证情况

已验证：

- 后端 mvn clean package
- 后端 mvn test
- 前端 
pm install
- 前端 
pm run build
- MySQL profile 下后端测试上下文

## 已知限制

- 尚未完成浏览器/API 端到端烟雾验证
- 前端生产构建仍有 chunk size 警告，但构建成功

## 后续扩展方向

- 可继续扩展考勤、宿舍、家长关联、综合统计
