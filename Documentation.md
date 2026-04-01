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
- continuation run materially deepened `student-management`, `library-management`, and `exam-system`
- the remaining seven seed projects now contain backend/frontend representative module scaffolds, startup notes, and inheritance notes
- extracted a reusable promotion checklist at `shared/specs/derived-project-promotion-checklist.md`
- `.gitignore` was expanded for multi-project Java/Vue/Node workspace hygiene
- `origin` now targets `https://github.com/qinghe-zy/DesignExample.git`
- local MySQL databases were created for all eleven project contexts using the `designexample_*` naming convention
- the completed repository state was pushed to both `origin/codex/bootstrap-template-factory` and `origin/main`

## Validation Results

- `mvn -q -DskipTests package` in `projects/00-base-admin/backend`: success
- `mvn -q test` in `projects/00-base-admin/backend`: success
- `npm.cmd install` in `projects/00-base-admin/frontend`: success
- `npm.cmd run build` in `projects/00-base-admin/frontend`: success with a chunk-size warning
- `Get-ChildItem projects | Select-Object -ExpandProperty Name`: confirmed all fixed seed project folders exist
- `mvn -q clean -DskipTests package` in `projects/student-management/backend`: success
- `mvn -q test` in `projects/student-management/backend`: success
- `npm.cmd install` in `projects/student-management/frontend`: success
- `npm.cmd run build` in `projects/student-management/frontend`: success with a chunk-size warning
- `mvn -q clean -DskipTests package` in `projects/library-management/backend`: success
- `mvn -q test` in `projects/library-management/backend`: success
- `npm.cmd install` in `projects/library-management/frontend`: success
- `npm.cmd run build` in `projects/library-management/frontend`: success with a chunk-size warning
- `mvn -q clean -DskipTests package` in `projects/exam-system/backend`: success
- `mvn -q test` in `projects/exam-system/backend`: success
- `npm.cmd install` in `projects/exam-system/frontend`: success
- `npm.cmd run build` in `projects/exam-system/frontend`: success with a chunk-size warning
- structure sanity checks confirmed backend/frontend representative module scaffolds for the remaining seven seeds
- `mysql -h localhost -P 3306 -u root -p123456 -e "SHOW DATABASES;"`: success
- local MySQL imports succeeded for all eleven `designexample_*` databases
- table-count verification succeeded across all initialized databases
- representative seed-data verification succeeded for `designexample_base_admin`, `designexample_student_management`, `designexample_library_management`, and `designexample_exam_system`
- backend test contexts succeeded against MySQL profile for `00-base-admin`, `student-management`, `library-management`, and `exam-system`
- `git push -u origin codex/bootstrap-template-factory`: success
- `git push origin codex/bootstrap-template-factory:main`: success
- `git ls-remote --heads origin`: success and confirmed both `main` and `codex/bootstrap-template-factory` exist on the remote

## Important Commands

- `git status --short --branch`
- `mvn -q -DskipTests package`
- `mvn -q test`
- `npm.cmd install`
- `npm.cmd run build`

## Known Issues

- `00-base-admin` frontend build reports a large chunk-size warning after bundling; build still succeeds
- npm reported 2 moderate vulnerabilities after dependency install; no fix was applied automatically in this run to avoid surprise dependency churn
- `student-management`, `library-management`, and `exam-system` are materially implemented and build-validated, but not yet smoke-tested through browser/API interaction
- the remaining seven seeds are materially stronger than empty scaffolds, but they are not yet promoted to runnable depth
- `git remote show origin` failed once with an SSL/TLS handshake error, but push and `ls-remote` verification still succeeded

## Installed Or Configured Tooling

- no additional tools installed so far
- workaround in use: prefer `npm.cmd` instead of `npm` in PowerShell sessions
- workaround in use: inline PowerShell generation instead of direct `.ps1` execution where execution policy blocks script invocation

## Next State

1. review `student-management`, `library-management`, and `exam-system` in real local runs with browser/API smoke checks
2. choose which of the remaining seven seeds should be promoted next, with `mall-system`, `blog-cms-forum`, `course-learning-platform`, and `erp-inventory-sales` as the strongest follow-up candidates
3. optionally create a local `main` branch if you want local branch names to mirror the remote delivery branch

## Git State

- current branch: `codex/bootstrap-template-factory`
- working tree: clean
- milestone commits:
  - `53f91b4` chore: initialize template factory governance
  - `15da901` feat: add runnable base admin baseline
  - `f41d3e6` feat: scaffold initial seed template projects
  - `ed5cd5f` docs: finalize unattended run handoff
  - `db513c2` docs: refresh final git metadata
  - `ea90011` feat: deepen top three seed projects
  - `c882e5c` feat: strengthen remaining seed project scaffolds
  - `69b2dcf` docs: sync continuation handoff state
  - `10a8d09` docs: refresh continuation git summary
  - `644562f` chore: finalize db verification and delivery hygiene
