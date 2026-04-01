# student-management

Student Management is a derived project built on top of the shared Projectexample admin baseline.

## Current Scope

- shared auth, system user/role/menu, and dashboard baseline inherited from 00-base-admin
- project-specific business focus: student archive, class-major coordination, score management, leave and discipline records
- MySQL-oriented SQL init under ./sql/mysql/init.sql and local H2 dev startup via backend resources

## Current Implementation Depth

Representative business modules currently implemented: Student Archive, Class & Major, Scores, Leave & Discipline.

## Startup Guide

### Backend

```powershell
cd D:\Projectexample\projects\student-management\backend
mvn -q clean -DskipTests package
mvn spring-boot:run
```

Optional MySQL-profile verification:

```powershell
$env:MYSQL_HOST='localhost'
$env:MYSQL_PORT='3306'
$env:MYSQL_USERNAME='root'
$env:MYSQL_PASSWORD='123456'
$env:SPRING_PROFILES_ACTIVE='mysql'
mvn -q test
```

### Frontend

```powershell
cd D:\Projectexample\projects\student-management\frontend
npm.cmd install
npm.cmd run dev
```

Default backend URL: http://localhost:8081
Default frontend URL: http://localhost:5181

## Validation Commands

- mvn -q clean -DskipTests package
- mvn -q test
- npm.cmd install
- npm.cmd run build

## Extension Direction

- keep auth/RBAC aligned with the shared base
- add richer statistics, workflow logic, and reporting after the current core modules are accepted
- extract repeated business patterns back into shared guidance when they stabilize
