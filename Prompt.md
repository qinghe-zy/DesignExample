# Prompt

## Stable Mission

Turn `Projectexample` into a durable academic project template factory for course-design and graduation-project systems.

The repository should support:

- future project additions
- shared engineering standards
- reusable blueprints
- consistent naming and layering
- long-term maintainability
- runnable starter templates
- future-friendly documentation
- low-rework generation of new project templates

## Success Criteria

The current unattended run is considered successful if it leaves behind, at minimum:

- root governance and durable memory files
- coherent workspace structure
- future-friendly architecture and workflow docs
- shared conventions and reusable baseline assets
- a documented base blueprint
- a runnable `projects/00-base-admin`
- an initial template catalog
- consistent seed template scaffolds beyond the base project when feasible
- verification notes, decisions, changelog, and operator handoff
- a clean reviewable git history

## Constraints

- reuse first, specialize second
- keep docs open-ended and extensible
- avoid random demo sprawl
- avoid overengineering
- prefer clean baseline consistency over shallow breadth
- document assumptions and tradeoffs explicitly

## Default Stack Baseline

- Backend: Java 17 target, Spring Boot 3, MyBatis-Plus, MySQL, JWT, Knife4j
- Frontend: Vue 3, TypeScript, Vite, Element Plus, Pinia, Vue Router

## Current Scope Priorities

1. stabilize the factory workspace
2. finish `projects/00-base-admin`
3. scaffold initial seed templates consistently
4. leave clear handoff guidance for future expansion
