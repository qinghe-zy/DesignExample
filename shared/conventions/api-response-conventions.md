# API Response Conventions

## Current Baseline Shape

Backend APIs in the current factory baseline should return a unified wrapper:

```json
{
  "code": 0,
  "message": "ok",
  "data": {}
}
```

Recommended meanings:

- `code = 0`: success
- non-zero code: business or validation failure

## Why This Baseline Exists

- keeps frontend integration predictable
- makes exception handling consistent
- avoids every module inventing a different response format

## Pagination Shape

For list pages, prefer:

```json
{
  "records": [],
  "total": 0,
  "pageNum": 1,
  "pageSize": 10
}
```

This is simple enough for student project scope while staying reusable across future templates.

## Error Handling

Prefer:

- global exception handling for unexpected failures
- validation error summaries that are easy for frontend forms to show
- explicit business messages for user-facing failures such as bad credentials or missing records

## Future Growth

This convention can later expand to include:

- trace identifiers
- localization keys
- warning payloads
- field-level validation payloads

The current baseline stays intentionally small so adoption remains easy.
