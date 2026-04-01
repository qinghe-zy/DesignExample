# 00-base-admin

`00-base-admin` is the current runnable baseline project for the Projectexample template factory.

It is intentionally minimal and reusable. The goal is to prove the shared stack, baseline module boundaries, and CRUD rhythm before generating richer business templates.

## Current Scope

### Backend

- Spring Boot 3
- Java 17 target
- MyBatis-Plus
- JWT auth skeleton
- unified response wrapper
- global exception handling
- dashboard overview API
- system user/role/menu list APIs
- representative notice CRUD API

### Frontend

- Vue 3 + TypeScript + Vite
- Element Plus admin shell
- Pinia auth store
- Vue Router protected routes
- login page
- dashboard page
- user/role/menu module skeleton pages
- notice CRUD page

## Current Credentials

- username: `admin`
- password: `admin123`

These are seed credentials for local baseline validation only. Replace them when deriving real projects.

## Current Folder Structure

```text
projects/00-base-admin/
├─ backend/
├─ frontend/
└─ sql/
   └─ mysql/
```

## Startup Guide

### Backend

```powershell
cd D:\Projectexample\projects\00-base-admin\backend
mvn -q -DskipTests package
mvn spring-boot:run
```

Current default local startup uses an H2 file database for low-friction validation while keeping MySQL initialization assets under `sql/mysql/`.

### Frontend

```powershell
cd D:\Projectexample\projects\00-base-admin\frontend
npm.cmd install
npm.cmd run dev
```

Default frontend dev URL:

- [http://localhost:5173](http://localhost:5173)

Default backend URL:

- [http://localhost:8080](http://localhost:8080)

## Validation Commands

```powershell
cd D:\Projectexample\projects\00-base-admin\backend
mvn -q -DskipTests package

cd D:\Projectexample\projects\00-base-admin\frontend
npm.cmd install
npm.cmd run build
```

Validation outcomes for the current unattended run are recorded in [Documentation.md](/D:/Projectexample/Documentation.md) and will be summarized in [HANDOFF.md](/D:/Projectexample/HANDOFF.md).

## Current Extension Points

- file upload handling
- operation log persistence
- chart/statistics enrichment
- future data dictionaries
- richer role and permission rules

## Why This Project Exists

This project is the baseline proof that the factory can produce a coherent admin starter. It is not the final shape of all future template families.
