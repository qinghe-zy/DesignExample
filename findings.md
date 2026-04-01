# Findings & Decisions

## Requirements
- Build the root workspace as a reusable academic project template factory, not a one-off demo repository.
- Read and obey `AGENTS.md`, `PROJECT_STANDARDS.md`, and `TEMPLATE_FACTORY_METHOD.md` before implementation.
- Create future-friendly root docs, shared assets, reusable blueprints, and one runnable base admin project.
- Use the default stack baseline unless there is a strong reason to diverge: Spring Boot 3 + Java 17 style backend, Vue 3 + TypeScript + Vite frontend, JWT + RBAC baseline.
- Leave clear extension points for future template categories, blueprints, modules, scripts, and standards revisions.

## Research Findings
- The current workspace only contains the three governance files; there is no existing project structure to preserve.
- The repository standards explicitly expect `docs/`, `scripts/`, `shared/`, `blueprints/`, and `projects/`, while allowing future top-level additions when justified.
- The template factory method distinguishes factory, blueprint, project, and module layers; the first run should establish the first three and leave module growth open.
- The environment has Java 21 and Maven 3.9.12 installed. This is compatible with generating Java 17-targeted projects if the Maven compiler is configured appropriately.
- Node.js is present and `npm.cmd` works even though PowerShell script execution blocks `npm.ps1`.

## Technical Decisions
| Decision | Rationale |
|----------|-----------|
| Create planning files in the repo root for this complex multi-phase task | Required by the planning workflow and useful for resumability |
| Treat Java 17 as the source/target baseline in Maven while building on installed JDK 21 | Keeps the generated template aligned with repo standards and broadly compatible |
| Organize the runnable example as `backend/` and `frontend/` inside `projects/00-base-admin/` | Makes the project easy to run and mirrors the blueprint split for future template generation |

## Issues Encountered
| Issue | Resolution |
|-------|------------|
| Workspace is not yet a git repository | Continue with initialization; avoid git-only steps |
| PowerShell policy blocks `npm.ps1` | Use `npm.cmd` for npm version checks and future commands |

## Resources
- `D:\Projectexample\AGENTS.md`
- `D:\Projectexample\PROJECT_STANDARDS.md`
- `D:\Projectexample\TEMPLATE_FACTORY_METHOD.md`
- `C:\Users\33398\.codex\skills\planning-with-files\SKILL.md`

## Visual/Browser Findings
- None in this run so far.

## Continuation Findings
- `00-base-admin` remained the only runnable project at the start of the continuation run.
- Deriving the top three seeds from the validated base project preserved auth/system consistency and reduced implementation risk.
- PowerShell bulk writes in this environment default to UTF-8 with BOM unless explicitly disabled, which breaks Java compilation for derived projects.
- The remaining seven seeds can be materially advanced with representative backend/frontend module files plus startup and inheritance notes without pretending they are already runnable.
