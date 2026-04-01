# Backend Blueprint Structure

## Current Recommended Structure

```text
backend/
├─ src/main/java/.../
│  ├─ common/
│  ├─ config/
│  ├─ controller/
│  ├─ dto/
│  ├─ entity/
│  ├─ exception/
│  ├─ mapper/
│  ├─ security/
│  ├─ service/
│  ├─ service/impl/
│  └─ vo/
├─ src/main/resources/
│  ├─ application.yml
│  ├─ schema.sql
│  └─ data.sql
└─ pom.xml
```

## Baseline Capabilities

- unified API response
- global exception handling
- JWT parsing and auth context
- user, role, and menu module skeletons
- dashboard overview endpoint
- representative CRUD business module

## Current Extension Points

- file upload service and storage strategy
- operation log persistence
- richer statistics and chart queries
- dictionary/config module extraction
- multi-role or data-scope security enhancements

## Notes

Keep controllers thin, services readable, and DTO/VO naming explicit. Avoid mixing business rules into configuration or controller classes.
