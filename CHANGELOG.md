# CHANGELOG

## 2026-04-01 初始阶段

### 已新增

- 根级治理文件与过程记忆文件
- 模板工厂总览文档
- 共享规范、蓝图说明、种子项目目录
- `00-base-admin` 可运行基础底座
- 10 个固定种子项目

### 已验证

- `00-base-admin` 后端构建与测试
- `00-base-admin` 前端安装与构建

## 2026-04-01 深化阶段

### 已新增

- `student-management` 重点派生实现
- `library-management` 重点派生实现
- `exam-system` 重点派生实现
- 其余 7 个项目的强化脚手架与代表模块
- 派生项目推进清单 `shared/specs/derived-project-promotion-checklist.md`

### 已验证

- 三个重点项目后端构建与测试
- 三个重点项目前端安装与构建

## 2026-04-01 最终清理与中文化阶段

### 已完成

- 全仓库主要对外文档中文化
- 根级文档、项目文档、蓝图文档、共享文档状态统一
- 修复文档中的过时描述、错误路径、复制残留
- 完善 `.gitignore`
- 配置远程 `origin`
- 推送到 GitHub 远程：
  - `origin/codex/bootstrap-template-factory`
  - `origin/main`

### 数据库相关

- 创建全部本地 `designexample_*` 数据库
- 导入 4 个重点数据库项目的完整 MySQL 初始化脚本
- 导入其余 7 个项目的 schema 基线
- 为 4 个重点后端项目补充 `application-mysql.yml`
- 修复 MySQL 不兼容的 `CLOB` 类型
- 验证 4 个重点后端项目在 MySQL profile 下可启动测试上下文

### 当前仍保留的注意事项

- 三个重点项目尚未做浏览器/API 端到端烟雾测试
- 其余 7 个项目仍是强化脚手架，不是同等深度的可运行项目
- 部分前端项目仍有 chunk size 警告，但构建成功
