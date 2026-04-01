# Template Catalog

## Purpose

This catalog records current seed template families that the factory is expected to support over time. It is intentionally open for future new entries, revised priorities, and deeper module decomposition.

## How To Read The Catalog

Each entry describes:

- template family
- common business modules
- reuse characteristics
- recommended build order
- likely extension points

The current catalog is a planning and reuse tool, not a promise that every listed template already exists.

## Seed Catalog Entries

| Template Family | Common Business Modules | Reuse Characteristics | Recommended Build Order | Likely Extension Points |
|----------------|-------------------------|-----------------------|-------------------------|-------------------------|
| Student management | students, classes, majors, attendance, scores, notices | very high reuse of users, roles, menus, CRUD forms, statistics | early | batch import, score analytics, guardian linkage, dorm linkage |
| Library management | books, categories, shelves, borrow records, overdue reminders | high reuse of CRUD, status workflows, dashboard counts | early | barcode support, reservations, fines, audit reports |
| Online exam system | question bank, papers, exam schedule, submissions, grading | medium reuse with stronger workflow complexity | after base admin and one simpler management template | random paper generation, anti-cheat, grading rules, analytics |
| Mall / e-commerce | products, categories, orders, customers, inventory | high CRUD reuse with more transaction logic | medium | coupons, payments, delivery, after-sales |
| Blog / CMS / forum | posts, categories, tags, comments, moderation | high reuse of admin baseline plus content workflow | medium | draft workflow, publishing pipeline, media library, SEO |
| Hotel booking | rooms, room types, bookings, check-in/out, pricing | medium reuse with scheduling and availability concerns | medium | seasonal pricing, customer profiles, invoicing, reports |
| HR / payroll / attendance | employees, departments, attendance, leave, payroll | high reuse of auth and CRUD with more rule-heavy modules | medium | approval workflow, salary formulas, document archive |
| Course / learning platform | courses, chapters, enrollments, assignments, progress | medium reuse with more portal-like features | medium to late | video progress, quizzes, certificate rules, notifications |
| Property / dorm / rental | buildings, rooms, tenants, leases, repairs, fees | high reuse of standard CRUD and status modules | early to medium | billing cycles, maintenance workflow, occupancy analytics |
| ERP / inventory / sales | suppliers, customers, products, stock, orders, procurement | high reuse with stronger cross-module linkage | medium to late | multi-warehouse, approval flow, finance linkage, dashboards |

## Reuse Observations

### High-Reuse Baseline Areas

These are expected to recur across many template families:

- login and current-user flow
- user/role/menu management
- dashboard summaries
- standard list/search/pagination pages
- create/edit dialogs and forms
- status management
- export/upload extension points

### Medium-Reuse Areas

These may later deserve deeper shared treatment once multiple templates stabilize:

- file attachment handling
- audit logs
- chart cards and trend summaries
- dictionary management
- workflow-style approval states

## Suggested Current Evolution Order

1. Base admin baseline
2. One or two management-heavy templates with high CRUD reuse
3. More workflow-heavy templates
4. Specialized blueprint growth if the current baseline becomes too stretched

## Adding Future Entries

When adding a new family, keep the same information shape:

- name
- common modules
- reuse characteristics
- recommended build order
- extension points

Additional columns can be added later if the catalog needs to track maturity, dependencies, or blueprint fit more precisely.
