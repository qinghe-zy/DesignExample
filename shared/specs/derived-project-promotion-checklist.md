# Derived Project Promotion Checklist

Use this checklist when promoting a seed project from documentation-heavy scaffold to materially implemented derived project.

## Baseline Carryover

- inherit the shared auth and RBAC baseline from `00-base-admin`
- keep system user/role/menu modules available unless there is a documented reason not to
- preserve the layered backend and frontend structure

## Business Deepening

- add 2-4 representative business modules for the target project
- create project-specific SQL schema and seed data
- wire project-specific menus and routes
- update dashboard text and metrics to reflect the new domain

## Validation

- run `mvn -q clean -DskipTests package`
- run `mvn -q test`
- run `npm.cmd install`
- run `npm.cmd run build`
- record warnings and blockers honestly

## Documentation

- update project README with startup and validation commands
- update module summary and extension notes
- record whether the project is runnable, partially implemented, or scaffold-first

## Extraction Rule

If the same promotion step or module pattern appears across multiple projects, consider moving the guidance or code pattern into `shared/` or the blueprint layer rather than repeating it indefinitely.
