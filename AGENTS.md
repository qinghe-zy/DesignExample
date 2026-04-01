\# AGENTS.md



\## Mission

You are operating inside the root workspace: `Projectexample`.



This repository is not a single business project.

It is a long-term, reusable, extensible \*\*academic project template factory\*\*.



Its purpose is to support the continuous creation, maintenance, and evolution of multiple course-design / graduation-project templates over time.



This workspace is expected to grow.

You must assume:

\- more templates may be added later

\- existing blueprints may evolve later

\- shared modules may expand later

\- folder structure and documentation should leave room for future additions



Your job is to build and maintain a clean, scalable foundation rather than a one-time closed set of templates.



\## Autonomous Execution Mode

You must work in autonomous execution mode:

\- do not wait for repeated confirmations

\- do not ask unnecessary clarification questions

\- make reasonable engineering decisions by yourself

\- document assumptions explicitly

\- prioritize maintainability, extensibility, and reuse over short-term completeness



\## Primary Goals

1\. Build a stable root-level engineering foundation first.

2\. Establish shared standards, shared modules, shared scripts, and shared documentation.

3\. Create reusable base blueprints rather than one-off demos.

4\. Make the workspace ready for continuous future template growth.

5\. Ensure each future project can be created, evolved, and maintained in a standardized way.



\## Working Mode

When starting work, always follow this order:



\### Phase 1: Inspect

\- inspect current directory structure

\- inspect existing files

\- identify missing foundations

\- identify whether current docs are too rigid or future-hostile

\- record assumptions if requirements are incomplete



\### Phase 2: Establish Root Governance

Create and maintain root-level governance files and structure, including but not limited to:

\- README

\- docs/

\- scripts/

\- blueprints/

\- shared/

\- projects/

\- template catalog

\- project creation rules

\- development conventions

\- naming conventions

\- delivery checklist

\- evolution policy



\### Phase 3: Build Reusable Foundation

Create reusable assets first:

\- base backend blueprint

\- base frontend blueprint

\- shared UI / utility / configuration conventions

\- shared module design notes

\- template creation rules

\- extension-point strategy for future modules and future project categories



\### Phase 4: Create Initial Runnable Base Template

Create one minimal but runnable base template project that proves:

\- frontend and backend can run

\- login / auth / RBAC skeleton exists

\- dashboard exists

\- generic CRUD flow exists

\- shared standards are applied



This initial runnable template is a starting point, not the final form of the whole workspace.



\### Phase 5: Report

After each major step, update documentation and output:

\- what was created

\- what assumptions were made

\- what remains next

\- what can be reused

\- what is intentionally left open for future expansion



\## Non-Negotiable Rules

\- Never turn the repo into a pile of unrelated demos.

\- Never assume the current initial template set is final.

\- Never create inconsistent projects with different architectures without strong justification.

\- Reuse first, specialize second.

\- Shared capabilities must be extracted whenever reasonable.

\- Prefer clear, layered architecture over clever shortcuts.

\- Prefer conventions and templates over copy-paste.

\- All generated content must remain editable and understandable by humans.

\- Every important decision must be reflected in documentation.

\- Documentation must not be written as if the workspace is already complete.



\## Technology Baseline

Default stack for templates:

\- Backend: Java 17, Spring Boot 3, MyBatis-Plus, MySQL, JWT, Knife4j

\- Frontend: Vue 3, TypeScript, Vite, Element Plus, Pinia, Vue Router

\- Build tools: Maven for backend, npm/pnpm for frontend

\- API style: RESTful

\- Data exchange: JSON

\- Auth baseline: JWT + RBAC



If details need to evolve later, preserve overall stack consistency unless there is a strong engineering reason.



\## Scope Control

At the current stage, do NOT directly build many business templates in full.



First build:

\- root workspace structure

\- root docs

\- template methodology

\- shared standards

\- base admin blueprint

\- initial catalog seeds for future templates

\- one runnable base admin example



Business templates should be added incrementally after the foundation is stable.



\## Initial Template Seeds

This workspace should be ready for initial template seeds such as:

\- student management

\- library management

\- online exam system

\- mall / e-commerce

\- blog / cms / forum

\- hotel booking

\- hr / payroll / attendance

\- course / learning platform

\- property / dorm / rental management

\- erp / inventory / sales



These are examples of likely initial categories, not a closed final list.



\## Skills Usage

This environment may contain many skills/tools.

Use them proactively when they clearly improve:

\- repo planning

\- code quality

\- architecture

\- frontend polish

\- documentation

\- validation

But do not overcomplicate the repo by using tools blindly.



\## Deliverable Quality

Everything created must be:

\- structured

\- documented

\- reusable

\- easy to extend

\- consistent in naming

\- consistent in code style

\- suitable for long-term template accumulation



\## Evolution Principle

Design every major asset with future growth in mind:

\- docs should support future sections

\- catalog should support new categories

\- scripts should support future project generation

\- blueprints should support future refinement

\- shared modules should allow later extraction and expansion



Avoid wording or structure that implies the current state is final.


## Documentation Flexibility Rule
All root documentation must be written with open-ended structure.
Use wording and headings that allow future sections, future templates, future scripts, and future standards revisions to be appended naturally.

Avoid documentation that assumes:
- the current project list is exhaustive
- the current folder structure is permanently final
- the current blueprint set is complete
- the current standards are the last revision



\## Autonomy Boundary

Autonomous execution means:

\- proceed without repeated confirmation for normal engineering decisions

\- create missing docs, structure, and scaffolds proactively

\- choose sane defaults when requirements are incomplete



But it does NOT mean:

\- introducing unnecessary frameworks

\- rewriting the whole workspace without reason

\- mass-producing business templates before the foundation is stable

\- adding fancy but low-value complexity

\- freezing future evolution through rigid documentation or closed structure



\## Output Style

When finishing a work cycle, summarize with:

1\. current progress

2\. files/folders created

3\. key engineering decisions

4\. next recommended step

5\. risks or unresolved assumptions

6\. future extension space intentionally left open

