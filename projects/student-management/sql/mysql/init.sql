DROP TABLE IF EXISTS biz_discipline_record;
DROP TABLE IF EXISTS biz_score_record;
DROP TABLE IF EXISTS biz_student_profile;
DROP TABLE IF EXISTS biz_student_class;
DROP TABLE IF EXISTS biz_notice;
DROP TABLE IF EXISTS sys_menu;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(64) NOT NULL,
    role_code VARCHAR(64) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE sys_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_code VARCHAR(64) NOT NULL,
    role_name VARCHAR(64) NOT NULL,
    remark VARCHAR(255),
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE sys_menu (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    path VARCHAR(128) NOT NULL,
    component VARCHAR(128),
    icon VARCHAR(64),
    permission_code VARCHAR(128),
    parent_id BIGINT NOT NULL DEFAULT 0,
    sort_no INT NOT NULL DEFAULT 0,
    menu_type VARCHAR(32) NOT NULL,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE biz_notice (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(128) NOT NULL,
    category VARCHAR(64) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    content CLOB NOT NULL,
    publish_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE biz_student_class (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(128) NOT NULL,
    major_name VARCHAR(128) NOT NULL,
    grade_level VARCHAR(32) NOT NULL,
    counselor VARCHAR(64) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE biz_student_profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_no VARCHAR(64) NOT NULL,
    student_name VARCHAR(128) NOT NULL,
    gender VARCHAR(16) NOT NULL,
    class_name VARCHAR(128) NOT NULL,
    major_name VARCHAR(128) NOT NULL,
    phone VARCHAR(32) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE biz_score_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_no VARCHAR(64) NOT NULL,
    student_name VARCHAR(128) NOT NULL,
    course_name VARCHAR(128) NOT NULL,
    term_name VARCHAR(64) NOT NULL,
    score_value DECIMAL(5, 2) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE biz_discipline_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_no VARCHAR(64) NOT NULL,
    student_name VARCHAR(128) NOT NULL,
    record_type VARCHAR(64) NOT NULL,
    description CLOB NOT NULL,
    record_date DATE NOT NULL,
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
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
    (6, 'Campus Notices', '/notices', 'notices/NoticeView', 'Bell', 'biz:notice:view', 0, 3, 'MENU', 0),
    (7, 'Student Affairs', '/student', '', 'Reading', 'student:view', 0, 4, 'MENU', 0),
    (8, 'Student Archive', '/student/archives', 'student/StudentArchiveView', 'User', 'student:archive:view', 7, 1, 'PAGE', 0),
    (9, 'Class & Major', '/student/classes', 'student/ClassManagementView', 'Collection', 'student:class:view', 7, 2, 'PAGE', 0),
    (10, 'Scores', '/student/scores', 'student/ScoreManagementView', 'Histogram', 'student:score:view', 7, 3, 'PAGE', 0),
    (11, 'Leave & Discipline', '/student/discipline-records', 'student/DisciplineRecordView', 'Document', 'student:discipline:view', 7, 4, 'PAGE', 0);

INSERT INTO biz_notice (id, title, category, status, content, deleted) VALUES
    (1, 'Student project baseline ready', 'platform', 1, 'The student-management template now provides a reusable login-dashboard-system-CRUD skeleton.', 0),
    (2, 'Current academic focus', 'planning', 1, 'The continuation run deepens archive, class, score, and discipline management around the shared base.', 0);

INSERT INTO biz_student_class (id, class_name, major_name, grade_level, counselor, status, deleted) VALUES
    (1, 'Software Engineering 2022-1', 'Software Engineering', '2022', 'Chen Lin', 1, 0),
    (2, 'Data Science 2023-2', 'Data Science', '2023', 'Wu Min', 1, 0);

INSERT INTO biz_student_profile (id, student_no, student_name, gender, class_name, major_name, phone, status, deleted) VALUES
    (1, '20220001', 'Li Hua', 'Male', 'Software Engineering 2022-1', 'Software Engineering', '13800001111', 1, 0),
    (2, '20230008', 'Wang Yue', 'Female', 'Data Science 2023-2', 'Data Science', '13800002222', 1, 0);

INSERT INTO biz_score_record (id, student_no, student_name, course_name, term_name, score_value, status, deleted) VALUES
    (1, '20220001', 'Li Hua', 'Java Web Development', '2024 Spring', 91.50, 1, 0),
    (2, '20230008', 'Wang Yue', 'Database Principles', '2024 Spring', 88.00, 1, 0);

INSERT INTO biz_discipline_record (id, student_no, student_name, record_type, description, record_date, status, deleted) VALUES
    (1, '20220001', 'Li Hua', 'Leave', 'Medical leave approved for two days', DATE '2024-03-12', 1, 0),
    (2, '20230008', 'Wang Yue', 'Merit', 'Recognized for strong project collaboration', DATE '2024-04-02', 1, 0);
