# 命名规范

## 目录命名

- 根级目录与项目目录统一使用小写 kebab-case
- 名称必须有清晰语义
- 避免无意义占位名

示例：

- `projects/00-base-admin`
- `projects/student-management`
- `blueprints/base-admin-template`

## 后端命名

- 包名使用小写点分形式，例如 `com.projectexample.studentmanagement`
- 控制器：`XxxController`
- 服务接口：`XxxService`
- 服务实现：`XxxServiceImpl`
- 映射器：`XxxMapper`
- 请求对象：`XxxSaveRequest`、`XxxQueryRequest`
- 返回对象：`XxxVO`

## 前端命名

- 视图组件：`XxxView.vue`
- store 文件：`xxx.ts`
- API 文件：`xxx.ts`
- 布局组件：`AdminLayout.vue`

## 数据库命名

- 系统表建议前缀：`sys_`
- 业务表建议前缀：`biz_`
- 字段命名保持稳定、可读

## 本地数据库命名

当前本地 MySQL 采用：

- `designexample_<project>`

例如：

- `designexample_student_management`
- `designexample_exam_system`
