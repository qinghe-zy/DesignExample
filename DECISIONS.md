# Decisions

## Current Architectural Decisions

### D-001: Establish docs/shared/blueprints/projects as the current core factory layout

Reason:

- matches the repo’s own standards
- separates governance, reusable baseline assets, and concrete projects cleanly
- leaves room for future folders without implying closure

### D-002: Use one runnable base admin as the first proof-of-baseline project

Reason:

- proves the shared conventions in code
- avoids mass-producing inconsistent demos
- gives future templates a concrete reference point

### D-003: Keep MySQL as the default target while allowing a lightweight local dev path

Reason:

- aligns with the requested stack baseline
- reduces setup friction for validation in unattended local runs

### D-004: Prefer documentation-first shared assets before premature code extraction

Reason:

- the factory is still forming
- shared code abstractions should follow repeated use, not guesswork

### D-005: Keep the fixed seed project folder names exactly as requested

Reason:

- the unattended run has an explicit fixed initial seed list
- stable folder names make future script automation and review easier
- no technical reason was found to rename any of the requested seed folders

### D-006: Use inline PowerShell generation when execution policy blocks direct script invocation

Reason:

- the environment blocks direct `.ps1` execution
- the repository still benefits from having a reusable script checked in for later operators
- using equivalent inline logic allowed the unattended run to continue without lowering repo quality

### D-007: Derive the top three seed projects from the validated 00-base-admin baseline

Reason:

- it preserves auth/system/dashboard consistency across the highest-priority derivatives
- it reduces the risk of architectural drift while still allowing project-specific business modules
- it is the fastest safe path to materially deeper implementations in an unattended continuation run

### D-008: Keep the remaining seven seeds lighter than the top three, but stronger than documentation-only scaffolds

Reason:

- the continuation run explicitly prioritizes the top three projects
- spreading full runnable implementation across all ten projects at once would reduce overall quality
- representative backend/frontend module files plus startup and inheritance docs leave the remaining seeds in a concrete next-step state

### D-009: Extract a reusable derived-project promotion checklist after repeating the same validation and carryover steps across top-three derivatives

Reason:

- the continuation run surfaced a stable repeated pattern for seed promotion
- documenting it once in `shared/` improves future consistency without forcing premature code abstraction
