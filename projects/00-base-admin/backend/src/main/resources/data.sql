INSERT INTO sys_role (id, role_code, role_name, remark, deleted) VALUES
    (1, 'ADMIN', 'Administrator', 'Current baseline super admin role', 0),
    (2, 'TEACHER', 'Teacher', 'Reserved role for future module expansion', 0);

INSERT INTO sys_user (id, username, password, nickname, role_code, status, deleted) VALUES
    (1, 'admin', '{noop}admin123', 'Factory Admin', 'ADMIN', 1, 0),
    (2, 'teacher', '{noop}teacher123', 'Template Teacher', 'TEACHER', 1, 0);

INSERT INTO sys_menu (id, name, path, component, icon, permission_code, parent_id, sort_no, menu_type, deleted) VALUES
    (1, 'Dashboard', '/dashboard', 'dashboard/DashboardView', 'Odometer', 'dashboard:view', 0, 1, 'MENU', 0),
    (2, 'System', '/system', '', 'Setting', 'system:view', 0, 2, 'MENU', 0),
    (3, 'Users', '/system/users', 'system/UserView', 'User', 'sys:user:view', 2, 1, 'PAGE', 0),
    (4, 'Roles', '/system/roles', 'system/RoleView', 'Collection', 'sys:role:view', 2, 2, 'PAGE', 0),
    (5, 'Menus', '/system/menus', 'system/MenuView', 'Menu', 'sys:menu:view', 2, 3, 'PAGE', 0),
    (6, 'Notices', '/notices', 'notices/NoticeView', 'Bell', 'biz:notice:view', 0, 3, 'MENU', 0);

INSERT INTO biz_notice (id, title, category, status, content, deleted) VALUES
    (1, 'Factory baseline ready', 'platform', 1, 'The base admin template now provides a reusable login-dashboard-system-CRUD skeleton.', 0),
    (2, 'Next seed templates', 'planning', 1, 'Student management, library management, and exam system are the highest-priority derived seeds.', 0);
