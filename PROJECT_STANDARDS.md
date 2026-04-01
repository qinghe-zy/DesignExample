\# PROJECT\_STANDARDS.md



\## 1. Repository Positioning

This repository is a long-term template factory, not a one-off demo collection.



All project templates must follow unified engineering standards so they can be:

\- reused

\- extended

\- renamed for different topics

\- evolved over time

\- maintained with low cost



The standards in this document define the current baseline, not a permanently closed final state.



\## 2. Root Structure Convention

Recommended root structure includes, but is not limited to:



\- docs/                 methodology, decisions, guides, future expansion docs

\- scripts/              helper scripts, setup scripts, generators

\- shared/               reusable shared assets and common definitions

\- blueprints/           reusable project blueprints / starter templates

\- projects/             concrete generated template projects

\- archive/              optional deprecated or experimental items



Additional folders may be introduced later if justified.

Do not assume the current top-level folder set is final forever.



\## 3. Naming Convention

\- Use lowercase kebab-case for folders

\- Use clear semantic names

\- Avoid vague names like demo1, test2, final-final

\- Business template folder examples:

&#x20; - student-management

&#x20; - library-management

&#x20; - exam-system

&#x20; - mall-system



When future template categories are added, naming should still remain consistent and semantic.



\## 4. Backend Standards

\- Java 17

\- Spring Boot 3

\- Maven multi-module is allowed if needed, but keep it understandable

\- Layered structure:

&#x20; - controller

&#x20; - service

&#x20; - service.impl

&#x20; - mapper

&#x20; - entity

&#x20; - dto

&#x20; - vo

&#x20; - config

&#x20; - common

&#x20; - exception

&#x20; - security



Requirements:

\- unified response wrapper

\- unified exception handling

\- clear validation strategy

\- config separated by environment

\- avoid business logic inside controller

\- avoid SQL scattering without structure

\- prefer generic reusable base services where appropriate

\- reserve clean extension points for future module growth



\## 5. Frontend Standards

\- Vue 3 + TypeScript + Vite

\- Element Plus as primary admin UI library

\- Pinia for state management

\- Vue Router for routing

\- api/, views/, components/, stores/, router/, utils/, hooks/ must be clearly separated

\- reusable table/form/dialog patterns should be abstracted when reasonable

\- avoid oversized single-file components

\- keep admin pages visually consistent

\- shared patterns must remain open for future component extraction



\## 6. Auth and Permission Standards

Every template should be prepared for:

\- login

\- logout

\- current user info

\- role-based access control

\- menu-based route control

\- operation-level permission extension points



Permission design should remain extensible for future project categories.



\## 7. Common Capability Baseline

Every business template should be able to inherit these capabilities:

\- authentication

\- user management

\- role management

\- menu management

\- dashboard

\- generic CRUD pages

\- search/filter/pagination

\- file upload

\- operation logs

\- export extension points

\- chart/statistics extension points



This baseline may expand over time.

Do not design it as a closed list.



\## 8. Database Standards

\- use clear table naming rules

\- include create/update time and logical delete fields where reasonable

\- avoid overdesigned schema

\- keep schema understandable for student projects

\- SQL init scripts must be provided

\- seed data should be controlled and documented

\- schema should leave room for future business-table expansion



\## 9. Documentation Standards

Every major asset should have documentation.



At minimum:

\- root README

\- blueprint guide

\- project startup guide

\- business module summary

\- table design summary

\- extension guide



Documentation must:

\- distinguish current baseline from future possibilities

\- avoid wording that implies the repository is finished

\- leave room for new templates, new modules, and new standards revisions



\## 10. Reuse Standards

Before adding new code, check whether it should belong in:

\- shared/

\- base blueprint

\- project local module



If something is likely to appear in multiple academic systems, extract it.



If something may become reusable later but is not yet mature, document it as a candidate rather than forcing premature abstraction.



\## 11. Code Quality Standards

\- readable first

\- stable first

\- reusable first

\- avoid unnecessary complexity

\- avoid hard-coded magic values

\- avoid duplicated CRUD patterns when abstraction is reasonable

\- keep comments useful, not noisy

\- keep future extension easier than short-term shortcuts



\## 12. Delivery Standards

A template is considered minimally qualified only if it has:

\- runnable frontend

\- runnable backend

\- startup instructions

\- db init script

\- base auth flow

\- at least one representative business module

\- documented extension points



\## 13. Change and Evolution Standards

This repository is expected to evolve.



Therefore:

\- standards may be refined later

\- folder structure may be extended later

\- shared capabilities may be extracted later

\- additional blueprint levels may appear later

\- new template categories may be added later



When making changes, prefer forward-compatible structure and wording.

Do not write standards as a frozen end-state.

