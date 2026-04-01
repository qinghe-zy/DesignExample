# Extension Points Checklist

Use this checklist when evolving the base admin blueprint or creating a new project from it.

## Core Baseline

- auth flow present
- user/role/menu baseline present
- dashboard baseline present
- at least one CRUD module present

## Extension Points To Keep Visible

- file upload strategy
- operation log design
- chart/statistics design
- export/import hooks
- dictionary/status management
- data-scope or multi-role security growth

## Documentation Expectation

When a project extends one of these areas, update:

- project README
- relevant docs under `shared/` if the pattern becomes reusable
- blueprint notes if the extension changes the recommended baseline
