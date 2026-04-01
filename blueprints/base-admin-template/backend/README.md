# 后端蓝图说明

## 当前推荐结构

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
│  ├─ data.sql
│  └─ application-mysql.yml（如需要本地 MySQL profile）
└─ pom.xml
```

## 当前能力基线

- 统一响应包装
- 全局异常处理
- JWT 认证解析
- 系统管理模块
- 仪表盘接口
- 至少一个代表业务模块

## 扩展点

- 文件上传
- 操作日志
- 图表统计
- 数据字典
- 更复杂的数据权限
