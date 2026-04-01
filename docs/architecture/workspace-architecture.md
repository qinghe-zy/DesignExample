# Workspace Architecture

## Purpose

This document describes the current recommended architecture for the `Projectexample` workspace. It is a baseline for continued growth, not a declaration that the workspace is structurally complete.

## Layer Model

### 1. Factory Layer

The factory layer governs the whole repository:

- root documents
- engineering standards
- methodology notes
- catalog entries
- reusable scripts
- long-term architecture decisions

Typical locations:

- `README.md`
- `AGENTS.md`
- `PROJECT_STANDARDS.md`
- `TEMPLATE_FACTORY_METHOD.md`
- `docs/`
- `scripts/`

### 2. Blueprint Layer

The blueprint layer captures reusable starter architecture for future projects. A blueprint should define:

- recommended backend and frontend structure
- shared baseline capabilities
- extension points
- setup assumptions
- documentation that explains how the blueprint is expected to evolve

Typical location:

- `blueprints/base-admin-template/`

### 3. Project Layer

The project layer contains runnable examples or generated systems based on a blueprint.

Typical location:

- `projects/00-base-admin/`
- future additions such as `projects/student-management/`

Projects should stay aligned with shared standards, but they may add topic-specific modules and docs.

### 4. Module Layer

The module layer is where reusable or project-specific business modules live over time. In the current baseline, this layer exists mainly as design intent and extension space. As patterns mature, module packages can be extracted into shared assets or future blueprint variants.

Examples of likely future module areas:

- students and classes
- library borrow/return
- exam banks and papers
- product and inventory
- blogs, CMS content, and forums

## Current Structure Boundaries

### Shared vs Project-Specific

Use `shared/` for assets that are expected to influence multiple templates:

- naming rules
- response conventions
- auth conventions
- CRUD patterns
- environment/config specs
- validation checklist
- current UI patterns
- module design notes

Keep project-local items inside a concrete project when they are still experimental or too business-specific to standardize cleanly.

### Blueprint vs Shared

Use `blueprints/` when the asset explains or provides a reusable project skeleton.

Use `shared/` when the asset is a cross-cutting rule, convention, or candidate for later extraction.

## Recommended Current Top-Level Structure

```text
Projectexample/
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
   └─ 00-base-admin/
```

Additional folders may be added later when they solve a real organizational problem. The current layout is intended to be stable enough for growth without pretending to be permanently exhaustive.

## Extension Strategy

### Extension Point A: New Template Families

Add new entries to the catalog first, then decide whether they can start from the base admin blueprint or need a sibling blueprint.

### Extension Point B: Shared Capabilities

When a capability appears repeatedly across projects, consider moving it into:

- shared conventions
- a richer blueprint
- a future extracted shared module

### Extension Point C: Tooling and Scripts

As template creation becomes more repetitive, `scripts/` can accumulate:

- naming validators
- project bootstrappers
- checklist generators
- quality gates

### Extension Point D: Additional Blueprints

Future sibling blueprints may include:

- `blueprints/base-mobile-friendly-template/`
- `blueprints/base-content-platform-template/`
- `blueprints/base-exam-template/`

Each blueprint should reuse as much of the shared baseline as practical.

## Architecture Decisions in the Current Baseline

| Decision | Current Direction |
|----------|-------------------|
| Backend stack | Spring Boot 3, Java 17 target, MyBatis-Plus, JWT, Knife4j-ready |
| Frontend stack | Vue 3, TypeScript, Vite, Element Plus, Pinia, Vue Router |
| Auth baseline | JWT + RBAC skeleton with menu and action extension points |
| Project form | Backend and frontend live together under each concrete project folder |
| Reuse rule | Extract when patterns repeat or clearly belong to the factory baseline |

## Intentional Open Space

The following areas are intentionally left open for future refinement:

- richer shared module extraction
- code generators beyond the current starter script
- more advanced auth policies such as tenant isolation or data permissions
- multiple blueprint families for specialized template types
- archive/deprecation handling for older templates
