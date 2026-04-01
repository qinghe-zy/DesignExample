# Development Workflow

## Purpose

This guide defines the current recommended workflow for maintaining and expanding the template factory.

## Standard Working Sequence

1. Inspect the current workspace state.
2. Read the applicable governance and standards files.
3. Decide whether the task belongs to `docs/`, `shared/`, `blueprints/`, or a concrete project.
4. Make the smallest reusable change that moves the factory forward.
5. Verify the affected project or document path.
6. Update documentation and record extension space if something remains intentionally open.

## Choosing Where Work Belongs

### Use `docs/` When

- the rule is for humans first
- the change affects future decisions across the workspace
- the asset explains architecture, workflow, catalog, or evolution

### Use `shared/` When

- the content is a reusable convention
- the pattern should guide multiple templates
- the asset may later evolve into a shared code module

### Use `blueprints/` When

- the asset describes or provides a repeatable project skeleton
- the decision should shape future templates directly

### Use `projects/` When

- the change belongs to a concrete runnable example
- the behavior is being proven in code rather than only described

## Current Verification Baseline

For non-trivial template work, verify as many of these as apply:

- backend dependency resolution
- backend compile or package
- frontend dependency install
- frontend build
- key login flow
- dashboard data load
- representative CRUD flow
- docs updated for the relevant path

If something cannot be verified in the current run, record that gap explicitly.

## Reuse Decision Rule

Ask these questions before adding new code:

1. Is this already covered by the blueprint?
2. Will this likely appear in multiple future templates?
3. Is the pattern mature enough to standardize now?

Preferred outcomes:

- shared convention if it is clearly cross-project
- blueprint update if it defines the starter baseline
- project-local implementation if it is still immature or business-specific

## Current Change Management Advice

- prefer incremental updates over large speculative abstractions
- keep folder names consistent and future-friendly
- document assumptions instead of silently freezing them into the repo
- avoid random demo artifacts that do not strengthen the factory

## Current Delivery Expectations

When finishing a meaningful work cycle, capture:

- what changed
- why the change belongs in that layer
- how it was verified
- what is still intentionally open for future additions

This helps future contributors extend the factory without reverse-engineering intent from code alone.
