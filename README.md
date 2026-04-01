# Projectexample

`Projectexample` is an evolving academic project template factory for course-design and graduation-project systems.

The current baseline focuses on reusable foundations rather than a large batch of business demos. The workspace is meant to accumulate shared standards, blueprints, starter projects, and catalog knowledge so future systems can be created with less copy-paste and more consistency.

## Current Baseline

This repository currently provides:

- root governance documents that describe the factory method and current standards
- shared engineering conventions for naming, API shape, auth, CRUD pages, and module layering
- a reusable base admin blueprint under [blueprints/base-admin-template](/D:/Projectexample/blueprints/base-admin-template)
- one runnable example project under [projects/00-base-admin](/D:/Projectexample/projects/00-base-admin)
- an initial template catalog that can be expanded as new template families are added
- helper workflow guidance and a starter script for new template initialization

The baseline is intentionally open-ended. More blueprints, shared modules, and concrete projects can be added later without treating the current layout as a fixed final state.

## Recommended Current Structure

```text
Projectexample/
├─ docs/                  workspace architecture, guides, catalog, and future notes
├─ scripts/               helper scripts for repeatable setup and project creation
├─ shared/                reusable conventions, notes, and future extractable assets
├─ blueprints/            reusable blueprint definitions and starter baselines
├─ projects/              runnable generated projects and verified examples
├─ AGENTS.md
├─ PROJECT_STANDARDS.md
└─ TEMPLATE_FACTORY_METHOD.md
```

See [workspace-architecture.md](/D:/Projectexample/docs/architecture/workspace-architecture.md) for the current layer model and extension strategy.

## Factory Layers

The current workspace is organized around four long-term layers:

1. Factory layer: repo-level standards, docs, scripts, and catalog assets.
2. Blueprint layer: reusable starter definitions, architecture baselines, and extension guidance.
3. Project layer: runnable examples generated from a blueprint plus selected business modules.
4. Module layer: future business capabilities that can be combined with the base admin stack.

The first three layers are established in this run. The module layer is intentionally left open for future extraction and template growth.

## Current Runnable Example

[projects/00-base-admin](/D:/Projectexample/projects/00-base-admin) is the current proof-of-baseline project. It demonstrates:

- Spring Boot backend with layered structure, JWT skeleton, unified response wrapper, and representative CRUD
- Vue 3 admin frontend with login, layout, dashboard, system pages, and CRUD page
- startup instructions and SQL initialization artifacts
- clear extension points for file upload, operation logs, chart/statistics, and future business modules

It is a starting point for future templates, not a closed final admin system.

## How New Templates Should Start

Use this general flow:

1. Pick a template family from the current catalog or add a new seed entry.
2. Start from [blueprints/base-admin-template](/D:/Projectexample/blueprints/base-admin-template).
3. Create a project folder under `projects/` using the current naming rules.
4. Keep auth, dashboard, user, role, and menu baselines unless there is a documented reason to change them.
5. Add business modules incrementally and update docs/schema along the way.
6. Record reusable patterns that should move into `shared/` or future blueprints.

Detailed guidance lives in [how-to-create-a-new-template.md](/D:/Projectexample/docs/guides/how-to-create-a-new-template.md).

## Important Working Assumptions

- Java 17 remains the source/target baseline for templates even if local machines use newer JDKs.
- MySQL remains the default business database target. The base project also includes a lightweight local dev path so the starter can be run quickly.
- JWT + RBAC is the current auth baseline.
- The current project list and folder layout are expected to evolve over time.

## Suggested Next Reading

- [workspace-architecture.md](/D:/Projectexample/docs/architecture/workspace-architecture.md)
- [development-workflow.md](/D:/Projectexample/docs/guides/development-workflow.md)
- [template-catalog.md](/D:/Projectexample/docs/catalog/template-catalog.md)
- [base-admin-template README](/D:/Projectexample/blueprints/base-admin-template/README.md)
- [00-base-admin README](/D:/Projectexample/projects/00-base-admin/README.md)
