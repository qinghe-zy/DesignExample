-- Current MySQL-oriented baseline schema and seed data for 00-base-admin.
-- This file mirrors the local dev schema/data intent while keeping MySQL as the default target database.

DROP TABLE IF EXISTS biz_notice;
DROP TABLE IF EXISTS sys_menu;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(64) NOT NULL,
    role_code VARCHAR(64) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted TINYINT NOT NULL DEFAULT 0
);

CREATE TABLE sys_role (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_code VARCHAR(64) NOT NULL,
    role_name VARCHAR(64) NOT NULL,
    remark VARCHAR(255),
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted TINYINT NOT NULL DEFAULT 0
);

CREATE TABLE sys_menu (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    path VARCHAR(128) NOT NULL,
    component VARCHAR(128),
    icon VARCHAR(64),
    permission_code VARCHAR(128),
    parent_id BIGINT NOT NULL DEFAULT 0,
    sort_no INT NOT NULL DEFAULT 0,
    menu_type VARCHAR(32) NOT NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted TINYINT NOT NULL DEFAULT 0
);

CREATE TABLE biz_notice (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(128) NOT NULL,
    category VARCHAR(64) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    content TEXT NOT NULL,
    publish_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted TINYINT NOT NULL DEFAULT 0
);

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
