# API Module Structure Guide

## Backend Layering

The current backend baseline separates:

- `controller`: request entry and response composition
- `service`: business contract
- `service.impl`: business implementation
- `mapper`: persistence access
- `entity`: persistence model
- `dto`: request payloads
- `vo`: response payloads
- `config`: framework and infrastructure configuration
- `common`: shared response, pagination, and base model support
- `exception`: global error handling
- `security`: auth parsing and security context support

## Frontend Layering

The current frontend baseline separates:

- `api/`: HTTP request wrappers
- `views/`: route-level pages
- `components/`: reusable presentation pieces
- `stores/`: Pinia state
- `router/`: route configuration and guards
- `utils/`: storage and formatting helpers
- `layouts/`: app shell and navigation structure
- `styles/`: theme variables and shared layout styles

## Rule Of Thumb

If a feature needs to be understood or replaced independently, it probably deserves its own layer file instead of being pushed into a giant component or controller.
