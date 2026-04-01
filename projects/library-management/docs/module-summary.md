# Module Summary

## Recommended Current Modules

- books
- categories
- shelves
- borrow records
- overdue reminders

## Inheritance From Shared Base

- inherit auth and RBAC from the library management template
- inherit dashboard shell and system baseline modules
- reuse the current CRUD page conventions
- keep topic-specific naming inside project-local business modules

## Suggested First Implementation Order

1. preserve login/dashboard/system baseline
2. implement the first representative business module
3. add reporting, import/export, and advanced workflows only after the core CRUD path is stable

