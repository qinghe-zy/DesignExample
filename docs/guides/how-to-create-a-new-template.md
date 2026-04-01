# How To Create a New Template

## Purpose

This guide describes the current recommended way to add a new template project to the factory while keeping the workspace reusable and maintainable.

## Before You Create Anything

Check these sources first:

1. [template-catalog.md](/D:/Projectexample/docs/catalog/template-catalog.md)
2. [workspace-architecture.md](/D:/Projectexample/docs/architecture/workspace-architecture.md)
3. [shared naming rules](/D:/Projectexample/shared/conventions/naming-rules.md)
4. [base-admin-template README](/D:/Projectexample/blueprints/base-admin-template/README.md)

The goal is to reuse first and specialize second.

## Recommended Creation Flow

### Step 1: Define the Template Family

Document:

- working name
- likely users
- common business modules
- which parts are shared with the current baseline
- which parts look specific enough to stay project-local at first

If the family is missing from the catalog, add it as a new seed entry instead of treating it as an untracked one-off.

### Step 2: Decide the Starting Point

Use `blueprints/base-admin-template` when the new project still fits the current admin baseline:

- login
- RBAC
- dashboard
- management tables/forms
- one or more standard CRUD modules

If the new template needs a very different interaction model, document the reason and consider creating a sibling blueprint later rather than forcing the mismatch into the base admin shape.

### Step 3: Initialize the Project Folder

Use lowercase kebab-case under `projects/`.

Examples:

- `projects/student-management`
- `projects/library-management`
- `projects/exam-system`

You can use [create-template.ps1](/D:/Projectexample/scripts/create-template.ps1) to create the standard directory shell for a new project.

### Step 4: Carry Over the Baseline Modules

A new template should usually inherit:

- auth flow
- user management
- role management
- menu management
- dashboard
- one shared CRUD pattern

These provide a stable administrative base and reduce repeated setup work.

### Step 5: Add Business Modules Incrementally

Do not dump every planned module into the first commit.

Prefer:

1. one representative business module
2. documentation and schema update
3. validation of reuse decisions
4. then additional modules

### Step 6: Record Reuse Candidates

If a project introduces a pattern that may appear elsewhere, document it in `shared/` or mark it in project docs as a future extraction candidate.

Examples:

- reusable upload policy
- reusable form layout sections
- reusable dictionary or status enum handling
- reusable statistics cards

### Step 7: Verify Before Calling It a Baseline

At minimum, verify:

- backend runs
- frontend runs
- login succeeds
- dashboard loads
- representative CRUD works
- SQL init script is usable
- startup instructions are accurate

## Current Do / Do Not Guidance

### Do

- keep naming semantic
- inherit the current standards unless there is a documented reason to diverge
- update the catalog and docs when introducing a new family
- leave room for future modules

### Do Not

- create topic-specific one-off architectures without justification
- rename shared concepts differently in every project
- over-abstract immature modules too early
- treat the first version of a template as the finished end-state

## Template Creation Checklist

- create the project folder
- add backend and frontend skeletons
- preserve auth/dashboard/system baseline
- add the first business module
- add SQL init scripts
- write project README
- record extension points
- note anything that should later move into `shared/` or a blueprint

## When To Create a New Blueprint Instead

Create or propose a new blueprint when several templates are drifting away from the current base admin pattern in the same direction, for example:

- content-heavy portal systems
- mobile-first student interaction systems
- exam engines with specialized workflow and scheduling

That way the factory evolves through deliberate blueprint growth rather than scattered project exceptions.
