# Plan

## Current Phase

Continuation Phase 6 complete: validation, documentation sync, and continuation milestone commits established

## Continuation Milestones

### Milestone 1: Inspect Existing State And Refresh Memory

- verify current repo state and project list
- read existing memory and rule files
- update continuation goals in repo memory files

Acceptance criteria:

- continuation assumptions are verified against the repo
- Prompt.md and Plan.md reflect the continuation mission

### Milestone 2: Student Management Deepening

- [x] create concrete backend/frontend code for student-management
- [x] add 2-4 representative business modules
- [x] provide SQL init, startup guide, and validation commands

Acceptance criteria:

- project is materially beyond documentation-only scaffolding
- best-effort build validation is attempted and documented

### Milestone 3: Library Management Deepening

- [x] create concrete backend/frontend code for library-management
- [x] add representative catalog/reader/borrow modules
- [x] provide SQL init, startup guide, and validation commands

Acceptance criteria:

- project is materially beyond documentation-only scaffolding
- best-effort build validation is attempted and documented

### Milestone 4: Exam System Deepening

- [x] create concrete backend/frontend code for exam-system
- [x] add representative question/paper/result modules
- [x] provide SQL init, startup guide, and validation commands

Acceptance criteria:

- project is materially beyond documentation-only scaffolding
- best-effort build validation is attempted and documented

### Milestone 5: Strengthen Remaining Seven Seeds

- [x] add backend/frontend structure and at least one representative business module scaffold to each remaining seed
- [x] add startup guidance and inheritance notes where still missing

Acceptance criteria:

- every fixed seed project has concrete module/file structure beyond empty shells
- docs and SQL baselines remain consistent with the shared base

### Milestone 6: Validation, Shared Refinement, Git, And Handoff

- [x] validate changed projects
- [x] extract any clearly repeated shared improvements
- [x] create milestone commits and update handoff

Acceptance criteria:

- validation results documented
- git state is reviewable
- final handoff clearly describes runnable vs partial work across all changed projects

## Validation Commands

- `git status --short --branch`
- `Get-ChildItem projects | Select-Object -ExpandProperty Name`
- `mvn -q -DskipTests package`
- `mvn -q test`
- `npm.cmd install`
- `npm.cmd run build`
- `Get-ChildItem -Recurse`

## Current Risks

- Windows PowerShell policy blocks direct `.ps1` execution and `npm.ps1`, so unattended commands use inline PowerShell logic and `npm.cmd`
- top three seed projects currently need real implementation depth, not just richer docs
- remaining seven projects need code/module scaffolds without fragmenting the architecture
- frontend bundle size warning exists for `00-base-admin` and may also appear in derived projects if they inherit the same bundling pattern
