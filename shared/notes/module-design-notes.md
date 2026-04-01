# Module Design Notes

## Purpose

This note captures the current thinking for designing reusable business modules in future templates.

## Current Module Heuristics

### Extract Early When

- the capability is already reused across multiple template families
- the workflow is stable
- naming can stay business-neutral

### Keep Local Longer When

- the module still depends on topic-specific wording
- the flow is not mature enough to standardize
- forcing reuse would introduce confusing abstraction

## Typical Module Shape

A future module usually includes:

- database table or tables
- entity and mapper
- service and controller
- list/search page
- create/edit form
- route/menu entry
- summary documentation

## Strong Reuse Candidates

- attachments/upload hooks
- dictionaries/status options
- audit trail stubs
- export hooks
- dashboard cards

## Intentional Open Space

This note is a starting point. Future revisions may add:

- module scoring for reuse maturity
- extraction criteria
- dependency rules between modules
- naming policies for shared business packages
