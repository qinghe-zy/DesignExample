# Environment And Config Patterns

## Backend

The current backend baseline should separate:

- default local-dev-friendly settings in `application.yml`
- environment-specific overrides in profile files when needed
- secrets through environment variables or later secret management instead of hard-coded production values

## Frontend

The current frontend baseline should use Vite environment variables for:

- API base URL
- future feature flags
- optional analytics or upload endpoints

## Current Recommended Approach

- keep local startup friction low
- keep production credentials out of source control
- document every non-obvious config variable in project README files

## Future Growth

This area can later define:

- profile naming strategy
- container/environment examples
- CI validation variables
- multi-project local orchestration conventions
