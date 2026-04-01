# DesignExample / Projectexample

`DesignExample`（本地工作目录仍为 `Projectexample`）是一个面向课程设计、毕业设计、教学管理类系统的**模板工厂仓库**。

它的定位不是单项目应用仓库，而是一个可持续维护的模板资产仓库，用来沉淀：

- 共享工程规范
- 共享蓝图
- 基础底座项目
- 种子项目
- 项目生成与扩展方法
- 数据库初始化与验证经验

## 当前仓库真实状态

当前仓库已具备：

- 根级治理与过程记忆文件
- `docs/`、`shared/`、`blueprints/`、`projects/` 的稳定基础结构
- 可运行基础底座项目 `projects/00-base-admin`
- 10 个固定种子项目
- 其中 3 个重点项目已达到“构建可通过 + MySQL profile 可验证”的较深实现状态：
  - `student-management`
  - `library-management`
  - `exam-system`
- 其余 7 个项目已达到“强化脚手架状态”，具备后续继续推进所需的代表模块与说明文档

## 当前仓库结构

```text
DesignExample/
├─ docs/          总览、架构、指南、模板目录
├─ scripts/       辅助脚本说明
├─ shared/        共享规范、共享说明、共享检查清单
├─ blueprints/    基础蓝图说明
├─ projects/      基础底座项目与种子项目
├─ AGENTS.md
├─ PROJECT_STANDARDS.md
├─ TEMPLATE_FACTORY_METHOD.md
├─ Prompt.md
├─ Plan.md
├─ Implement.md
├─ Documentation.md
├─ DECISIONS.md
├─ CHANGELOG.md
└─ HANDOFF.md
```

当前结构是**现阶段推荐结构**，不是永久封闭目录树。后续可在不破坏清晰分层的前提下继续扩展。

## 当前基础底座

[projects/00-base-admin](/D:/Projectexample/projects/00-base-admin) 是当前共享基础底座，负责提供：

- 后端分层基线
- 前端管理端基线
- 登录 / 登出 / 当前用户
- JWT + RBAC 基线
- 仪表盘
- 用户 / 角色 / 菜单
- 通用 CRUD 页面范式
- 本地 H2 快速验证路径
- MySQL 初始化脚本与 MySQL profile 验证路径

它是后续派生项目的统一起点，而不是所有业务项目的最终形态。

## 当前项目分层

### 1. 工厂层

由根级治理文件、`docs/`、`shared/`、`scripts/` 构成，负责描述：

- 仓库定位
- 工程标准
- 模板方法
- 演进策略
- 验证规则

### 2. 蓝图层

由 `blueprints/` 构成，负责描述：

- 可复用起始架构
- 蓝图边界
- 扩展点

### 3. 项目层

由 `projects/` 构成，包含：

- `00-base-admin`
- 10 个固定种子项目

### 4. 模块层

模块层存在于具体项目内部，当前已在三个重点项目中形成真实业务模块，在其余项目中形成代表性模块骨架。

## 当前项目状态一览

### 可运行 / 已较深实现

- `00-base-admin`
- `student-management`
- `library-management`
- `exam-system`

说明：

- 后端构建通过
- 后端测试通过
- 前端安装与构建通过
- 数据库已完成本地初始化
- MySQL profile 下测试上下文可启动

### 强化脚手架状态

- `mall-system`
- `blog-cms-forum`
- `hotel-booking`
- `hr-payroll-attendance`
- `course-learning-platform`
- `property-rental-dorm`
- `erp-inventory-sales`

说明：

- 已有项目 README
- 已有后端/前端 README
- 已有模块说明、扩展说明、继承说明、启动建议
- 已有 SQL/schema 基线
- 已有代表业务模块骨架
- 尚未推进到与重点项目同等的运行深度

## 本地数据库规则

本地 MySQL 当前采用以下命名规则：

- `designexample_base_admin`
- `designexample_student_management`
- `designexample_library_management`
- `designexample_exam_system`
- `designexample_mall_system`
- `designexample_blog_cms_forum`
- `designexample_hotel_booking`
- `designexample_hr_payroll_attendance`
- `designexample_course_learning_platform`
- `designexample_property_rental_dorm`
- `designexample_erp_inventory_sales`

该规则用于避免本机已有数据库冲突，并支持后续统一初始化与验证。

## Git 与交付分支

当前工作分支：

- `codex/bootstrap-template-factory`

当前远程可见交付分支：

- `main`

远程仓库地址：

- [https://github.com/qinghe-zy/DesignExample.git](https://github.com/qinghe-zy/DesignExample.git)

## 阅读顺序建议

建议按以下顺序理解仓库：

1. [PROJECT_STANDARDS.md](/D:/Projectexample/PROJECT_STANDARDS.md)
2. [TEMPLATE_FACTORY_METHOD.md](/D:/Projectexample/TEMPLATE_FACTORY_METHOD.md)
3. [docs/architecture/workspace-architecture.md](/D:/Projectexample/docs/architecture/workspace-architecture.md)
4. [docs/catalog/template-catalog.md](/D:/Projectexample/docs/catalog/template-catalog.md)
5. [projects/00-base-admin/README.md](/D:/Projectexample/projects/00-base-admin/README.md)
6. 三个重点项目 README

## 后续优先建议

如果继续推进，建议优先顺序为：

1. 对 `student-management`、`library-management`、`exam-system` 做浏览器/API 级别烟雾验证
2. 继续深化：
   - `mall-system`
   - `blog-cms-forum`
   - `course-learning-platform`
   - `erp-inventory-sales`
3. 在重复模式成熟后，进一步抽取共享能力与蓝图能力
