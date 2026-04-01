# Implement

## Execution Runbook

Use this file as the working runbook for unattended execution.

## Working Rules

1. inspect before editing
2. prefer minimal viable reusable structure
3. update Documentation.md, DECISIONS.md, CHANGELOG.md, and HANDOFF.md as milestones move
4. validate after each major milestone
5. repair drift or inconsistency before expanding scope

## Current Implementation Order

1. durable memory files
2. git baseline
3. docs and shared assets
4. base blueprint
5. runnable `00-base-admin`
6. seed template scaffolds
7. validation and handoff

## Current Assumptions

- local JDK 21 can build Java 17-targeted code via Maven `release=17`
- local quick-start may use H2 while keeping MySQL as the default target database for real template evolution
- seed template scaffolds can be documentation-first if full implementation would compromise baseline quality

## Self-Correction Trigger

If the repo starts accumulating duplicate structures, topic-specific naming in shared assets, or inconsistent architectures between projects, pause expansion and repair the shared baseline first.
