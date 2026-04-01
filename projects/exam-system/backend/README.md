# Backend Seed Scaffold

This seed should derive backend structure from projects/00-base-admin/backend.

## Priority Modules

- question bank
- papers
- exam plans
- submissions
- grading

## Current Recommendation

- keep the same controller/service/mapper/entity/dto/vo layering
- keep JWT + RBAC from the base admin baseline
- add business tables and services incrementally
- avoid topic-specific shortcuts inside shared system modules

