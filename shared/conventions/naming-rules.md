# Naming Rules

## Purpose

These are the current naming rules for the template factory and the projects generated from it.

## Folder Naming

- use lowercase kebab-case for root folders and project folders
- keep names semantic and reusable
- avoid placeholders such as `demo`, `test`, `final`, or `temp`

Examples:

- `projects/00-base-admin`
- `projects/student-management`
- `blueprints/base-admin-template`

## Backend Naming

- package names: lowercase dot notation, for example `com.projectexample.baseadmin`
- controllers: `XxxController`
- services: `XxxService`
- service implementations: `XxxServiceImpl`
- mappers: `XxxMapper`
- DTOs: `XxxCreateRequest`, `XxxUpdateRequest`, `XxxQueryRequest`
- VOs: `XxxVO`

## Frontend Naming

- views: `XxxView.vue`
- stores: `useXxxStore` naming inside `xxx.ts`
- api modules: `xxx.ts`
- layout components: descriptive names such as `AdminLayout.vue`

## Database Naming

- prefer table prefixes for shared/system tables such as `sys_`
- prefer business-semantic names for business tables such as `biz_notice`
- keep field names readable and stable
- include `create_time`, `update_time`, and `deleted` where appropriate

## Growth Note

These rules may be extended as more blueprint families and shared modules appear. Keep new names compatible with the current style unless there is a strong reason to evolve the convention.
