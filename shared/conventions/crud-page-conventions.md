# CRUD Page Conventions

## Purpose

These conventions keep management pages consistent across future templates.

## Recommended Page Composition

A standard CRUD page should usually include:

- page title and short purpose line
- filter/search area
- action toolbar
- table or list area
- pagination
- create/edit dialog or drawer

## Current Interaction Pattern

- search state should be explicit and resettable
- primary actions should stay near the filter area
- destructive actions should require confirmation
- form validation should happen on both frontend and backend

## Form Suggestions

- keep labels clear and short
- group related fields together
- use selects for bounded status/category values
- reserve rich text or upload areas only when the module actually needs them

## Table Suggestions

- include stable key fields
- show status values consistently
- keep action columns predictable
- avoid overly dense tables for beginner-maintainable templates

## Reuse Targets

As the workspace grows, these elements are strong candidates for shared frontend extraction:

- filter toolbar wrapper
- table card shell
- status tag renderer
- dialog form scaffolding
- pagination binding helper
