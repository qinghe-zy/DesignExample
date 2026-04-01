# 前后端分层结构规范

## 后端分层

后端当前建议包含：

- `controller`
- `service`
- `service.impl`
- `mapper`
- `entity`
- `dto`
- `vo`
- `config`
- `common`
- `exception`
- `security`

## 前端分层

前端当前建议包含：

- `api/`
- `views/`
- `components/`
- `stores/`
- `router/`
- `utils/`
- `hooks/`
- `layouts/`
- `styles/`

## 判断规则

如果一个能力需要被单独理解、单独替换、单独维护，那它就不应被塞进巨大的单文件或巨大的控制器里。
