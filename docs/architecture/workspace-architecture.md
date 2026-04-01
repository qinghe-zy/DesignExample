# 工作空间架构说明

## 文档目的

本文档用于说明 `DesignExample` 当前推荐的工作空间架构。

它描述的是**当前可持续使用的结构基线**，不是永久固定不变的最终形态。

## 四层结构模型

### 1. 工厂层（Factory Layer）

用于治理整个仓库的根级资产，包括：

- 根级说明文档
- 工程标准
- 方法论
- 模板目录
- 辅助脚本
- 关键决策记录

典型位置：

- `README.md`
- `AGENTS.md`
- `PROJECT_STANDARDS.md`
- `TEMPLATE_FACTORY_METHOD.md`
- `Prompt.md`
- `Plan.md`
- `Documentation.md`
- `docs/`
- `scripts/`

### 2. 蓝图层（Blueprint Layer）

用于定义可复用的起始结构与项目边界，包括：

- 基础管理端蓝图
- 后端/前端结构建议
- 扩展点说明
- 启动与初始化建议

典型位置：

- `blueprints/base-admin-template/`

### 3. 项目层（Project Layer）

用于承载具体项目实例，包括：

- 基础底座项目 `projects/00-base-admin`
- 深化中的重点项目
- 强化脚手架状态的种子项目

### 4. 模块层（Module Layer）

用于承载具体业务模块。

模块层当前存在于各个项目内部，随着重复模式逐渐稳定，未来可进一步向共享层或蓝图层抽取。

## 当前目录边界

### shared 与 project 的边界

放入 `shared/` 的内容应满足以下至少一项：

- 面向多个项目复用
- 属于共用工程约定
- 属于共享检查清单或共享说明
- 未来很可能进一步演化为共享代码资产

放入项目目录的内容应满足以下特点：

- 当前仍然偏业务化
- 尚未成熟到共享抽取
- 需要在具体项目内先验证

### blueprint 与 shared 的边界

- `blueprints/` 负责“项目如何起步”
- `shared/` 负责“项目应遵循什么共性规则”

## 当前推荐根级结构

```text
DesignExample/
├─ docs/
│  ├─ architecture/
│  ├─ guides/
│  └─ catalog/
├─ scripts/
├─ shared/
│  ├─ conventions/
│  ├─ specs/
│  ├─ ui-patterns/
│  └─ notes/
├─ blueprints/
│  └─ base-admin-template/
└─ projects/
   ├─ 00-base-admin/
   ├─ student-management/
   ├─ library-management/
   └─ ...
```

## 当前扩展策略

### 扩展点 A：新增模板类别

新增模板类别时，应先补充模板目录，再决定它：

- 是否可直接从 `base-admin-template` 派生
- 是否需要形成新的兄弟蓝图

### 扩展点 B：共享能力抽取

当多个项目重复出现同一类模式时，可考虑继续抽取：

- 共享表单 / 表格 / 弹窗模式
- 共享 API 客户端模式
- 共享权限与菜单模式
- 共享数据库初始化规则

### 扩展点 C：脚本与自动化

后续可继续增强：

- 命名校验
- 项目生成
- 检查清单生成
- 一致性巡检

## 当前真实项目状态

### 已较深实现并已验证

- `00-base-admin`
- `student-management`
- `library-management`
- `exam-system`

### 已强化但仍以脚手架为主

- `mall-system`
- `blog-cms-forum`
- `hotel-booking`
- `hr-payroll-attendance`
- `course-learning-platform`
- `property-rental-dorm`
- `erp-inventory-sales`

## 有意保留的扩展空间

以下内容仍保留为未来空间：

- 新蓝图类别
- 更深层的共享模块抽取
- 端到端运行验证脚本
- 浏览器级烟雾测试
- 更细粒度的项目生成与初始化自动化
