# Frontend Blueprint Structure

## Current Recommended Structure

```text
frontend/
├─ src/
│  ├─ api/
│  ├─ components/
│  ├─ layouts/
│  ├─ router/
│  ├─ stores/
│  ├─ styles/
│  ├─ utils/
│  └─ views/
│     ├─ login/
│     ├─ dashboard/
│     ├─ system/
│     └─ <business-module>/
├─ index.html
├─ package.json
└─ vite.config.ts
```

## Baseline Screens

- login page
- admin layout with sidebar and header
- dashboard overview
- user list
- role list
- menu list
- one representative CRUD page

## Current UX Direction

The current base admin baseline should feel:

- clear
- modern
- stable
- easy for future student projects to extend

It should avoid generic demo clutter while staying maintainable for long-term reuse.

## Current Extension Points

- upload widgets
- richer dashboards and chart widgets
- dictionary-driven form controls
- more advanced route/permission composition
- reusable CRUD page shells
