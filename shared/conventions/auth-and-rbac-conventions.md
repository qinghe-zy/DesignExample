# Auth And RBAC Conventions

## Current Baseline

The current baseline uses:

- JWT for authentication
- role-based access control
- menu-based navigation control
- operation-level permission extension points

## Minimum Auth Flow

1. user submits username and password
2. backend validates credentials
3. backend issues JWT token
4. frontend stores token and fetches current user data
5. protected APIs require a valid bearer token

## Role Model

Current baseline assumptions:

- one user can have at least one primary role
- roles carry permission meaning
- menus can be filtered or tagged by role/permission

This can later evolve into richer mappings such as many-to-many user-role relations or data-scope policies.

## Menu And Permission Model

Current menu fields should be able to support:

- sidebar menus
- nested navigation
- route path
- permission code
- sort order
- icon hints

Operation permissions should remain easy to extend, for example:

- `sys:user:view`
- `sys:user:edit`
- `biz:notice:create`

## Logout

The current baseline treats logout as a client token clear plus future server-side invalidation extension space.

## Future Extension Space

Likely future additions:

- refresh tokens
- multi-role aggregation
- department/data permissions
- tenant isolation
- login audit trail
