# Base Admin Template Blueprint

## Purpose

This blueprint defines the current standard starting point for management-oriented academic systems in the factory.

It is designed to be reused, copied, refined, and eventually expanded with sibling blueprints if future template families need a different baseline.

## What The Blueprint Covers

- backend layered structure
- frontend admin shell structure
- JWT + RBAC skeleton
- dashboard skeleton
- system baseline modules: user, role, menu
- representative CRUD module pattern
- reserved extension points for upload, logs, and statistics

## Blueprint Layout

- [backend README](/D:/Projectexample/blueprints/base-admin-template/backend/README.md)
- [frontend README](/D:/Projectexample/blueprints/base-admin-template/frontend/README.md)
- [extension-points checklist](/D:/Projectexample/blueprints/base-admin-template/checklists/extension-points.md)

## Current Baseline Assumptions

- backend uses Spring Boot 3 with Java 17 target
- frontend uses Vue 3 + TypeScript + Vite
- the base experience is an admin-style management interface
- auth is JWT-based with role and menu concepts available from day one

## Recommended Uses

Start from this blueprint when the future project needs:

- an admin login
- management tables and forms
- baseline system management
- standard dashboard metrics
- one or more CRUD-heavy business modules

## When To Avoid Forcing This Blueprint

If a future template is mainly:

- consumer-facing
- mobile-first
- workflow-heavy in a way that breaks the current admin rhythm

then record that mismatch and consider a future sibling blueprint rather than forcing the project into the wrong shape.
