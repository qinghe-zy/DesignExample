\# TEMPLATE\_FACTORY\_METHOD.md



\## Goal

Build a reusable, extensible academic-project template factory.



The factory should support repeated and continuous generation of high-frequency course-design / graduation-project systems with minimal rework and clear room for future expansion.



\## Core Principle

One stable base, multiple business variants, continuous future growth.



Do not repeatedly create unrelated projects from scratch.

Instead:

1\. define a stable base architecture

2\. define shared capabilities

3\. define business-module slots

4\. define extension strategy for future template categories

5\. generate new templates by combining shared base + business modules + topic-specific naming



\## Design Mindset

Treat the workspace as an evolving platform, not a closed batch task.



This means:

\- current blueprints are starting points

\- current catalogs are initial seeds

\- current project folders are current examples

\- future additions are expected, not exceptional



\## Standard Delivery Layers



\### Layer A: Factory Layer

Root-level assets that govern the whole workspace:

\- methodology docs

\- standards docs

\- catalog

\- scripts

\- blueprint definitions

\- evolution notes



\### Layer B: Blueprint Layer

Reusable starter templates and reusable structural definitions:

\- backend blueprint

\- frontend blueprint

\- base admin blueprint

\- common CRUD blueprint

\- common auth blueprint

\- future blueprints as needed



\### Layer C: Project Layer

Concrete generated projects, for example:

\- projects/00-base-admin

\- projects/student-management

\- projects/library-management



The set of project folders is open-ended and may grow later.



\### Layer D: Module Layer

Business-specific modules added into projects:

\- student module

\- score module

\- borrow module

\- exam paper module

\- inventory module

\- future modules as needed



\## Template Creation Strategy

When creating a new template:

1\. start from the base admin blueprint

2\. keep auth / dashboard / user / role / menu foundations

3\. add one or more business modules

4\. update docs and schema

5\. list extension points

6\. avoid hard-coding assumptions that block future evolution



\## First-Stage Scope

Before mass-producing templates, first complete:

\- root repo structure

\- standards

\- methodology

\- template catalog seeds

\- generator guide or helper script

\- one runnable base admin template



These are the initial foundation steps, not the full future scope.



\## Initial Template Catalog Seeds

The initial template catalog may include categories such as:

\- student management

\- library management

\- online exam

\- mall system

\- blog/cms/forum

\- hotel booking

\- hr/payroll

\- course learning platform

\- property/dorm/rental

\- erp/inventory/sales



These are seed categories, not the final complete catalog.



Each catalog item should record:

\- template name

\- typical modules

\- reuse rate

\- difficulty

\- recommended evolution path

\- likely extension points



The catalog structure must support future new entries.



\## Reuse Policy

If a capability appears in 3 or more templates, it should probably be shared or abstracted.



If a capability is not yet mature enough for extraction, document it as a reuse candidate and keep the structure ready.



\## Progression Policy

Recommended early progression:

1\. base admin

2\. one or two highly reusable management systems

3\. additional systems generated from the stable base

4\. later refinements to shared capabilities and scripts



This order may be adjusted later as the workspace evolves.



\## Decision Policy

When requirements are incomplete:

\- make the smallest reasonable assumption

\- record it

\- move forward

\- do not block progress unnecessarily

\- avoid turning temporary assumptions into rigid permanent structure



\## Future Expansion Policy

The factory should remain ready for:

\- new business categories

\- new blueprint variants

\- deeper shared module extraction

\- improved scripts

\- documentation growth

\- new frontend or backend refinements within the same overall stack strategy



\## Final Standard

The workspace should eventually feel like a small internal template platform, not a random folder of student demos and not a closed one-time batch of templates.

