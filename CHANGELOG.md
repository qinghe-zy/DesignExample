# Changelog

## 2026-04-01

### Added

- root durable memory files for unattended execution
- root README and required factory docs
- shared conventions and notes
- shared specs and UI pattern notes
- base admin blueprint documentation
- runnable `projects/00-base-admin`
- all ten fixed initial seed project folders with README, module summary, extension notes, and SQL/schema baseline
- richer seed scaffolds for `student-management`, `library-management`, and `exam-system`

### Validation

- backend package succeeded
- backend test context succeeded
- frontend dependency install succeeded
- frontend production build succeeded with a chunk-size warning

### In Progress

- remote configuration and optional push by a later operator

## 2026-04-01 Continuation

### Added

- derived business modules for `student-management`
- derived business modules for `library-management`
- derived business modules for `exam-system`
- backend/frontend representative module scaffolds for the remaining seven seed projects
- startup guides and inheritance notes for the remaining seven seed projects
- `shared/specs/derived-project-promotion-checklist.md`

### Validation

- top three seed backends built successfully with `mvn -q clean -DskipTests package`
- top three seed backend test contexts passed with `mvn -q test`
- top three seed frontends installed successfully with `npm.cmd install`
- top three seed frontends built successfully with `npm.cmd run build`

### Notes

- top three seed frontends still emit large bundle-size warnings during Vite production builds
- the remaining seven seeds are materially advanced but intentionally lighter than the top three
