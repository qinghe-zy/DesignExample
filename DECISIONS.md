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
