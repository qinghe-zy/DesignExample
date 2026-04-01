# Documentation

## Environment Findings

- Root inspected on 2026-04-01.
- Initial root files found: `AGENTS.md`, `PROJECT_STANDARDS.md`, `TEMPLATE_FACTORY_METHOD.md`.
- Initial workspace state contained no `docs/`, `shared/`, `blueprints/`, or `projects/` content.
- `git status` initially failed because the folder was not a git repository.
- Git was initialized during this run.
- Java available: JDK 21.
- Maven available: 3.9.12.
- Node available: v24.13.1.
- `npm.cmd` works; `npm.ps1` is blocked by PowerShell execution policy.
- direct `.ps1` invocation is blocked by PowerShell execution policy, so seed generation used inline PowerShell logic instead of calling `scripts/create-template.ps1` directly
- `pnpm` not found.

## Current Progress Summary

- root docs and shared conventions created
- base admin blueprint docs created
- `projects/00-base-admin` backend and frontend implemented to the current baseline
- backend packaged successfully and test context loaded successfully
- frontend installed dependencies and built successfully
- all ten fixed seed template folders were created with docs and SQL/schema baselines
- the top three seed templates (`student-management`, `library-management`, `exam-system`) received richer scaffolds than the other seeds

## Important Commands

- `git status --short --branch`
- `mvn -q -DskipTests package`
- `mvn -q test`
- `npm.cmd install`
- `npm.cmd run build`

## Known Issues

- `00-base-admin` frontend build reports a large chunk-size warning after bundling; build still succeeds
- npm reported 2 moderate vulnerabilities after dependency install; no fix was applied automatically in this run to avoid surprise dependency churn
- seed projects are scaffolded and documented, but they are not yet implemented to the same runnable level as `00-base-admin`

## Installed Or Configured Tooling

- no additional tools installed so far
- workaround in use: prefer `npm.cmd` instead of `npm` in PowerShell sessions
- workaround in use: inline PowerShell generation instead of direct `.ps1` execution where execution policy blocks script invocation

## Next State

1. sync final documentation files with validation and git results
2. create milestone commits and final summary commit
3. attempt branch creation and remote push discovery
4. finalize HANDOFF.md for human review
