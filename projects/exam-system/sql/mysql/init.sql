DROP TABLE IF EXISTS biz_exam_record;
DROP TABLE IF EXISTS biz_exam_paper;
DROP TABLE IF EXISTS biz_question_bank;
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

CREATE TABLE biz_question_bank (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(64) NOT NULL,
    question_type VARCHAR(32) NOT NULL,
    difficulty_level VARCHAR(32) NOT NULL,
    stem CLOB NOT NULL,
    answer_key VARCHAR(255) NOT NULL,
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE biz_exam_paper (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    paper_name VARCHAR(128) NOT NULL,
    course_name VARCHAR(128) NOT NULL,
    duration_minutes INT NOT NULL,
    total_score INT NOT NULL,
    publish_status INT NOT NULL DEFAULT 0,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);

CREATE TABLE biz_exam_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(128) NOT NULL,
    paper_name VARCHAR(128) NOT NULL,
    attempt_date DATE NOT NULL,
    score_value DOUBLE NOT NULL,
    status INT NOT NULL DEFAULT 0,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted INT NOT NULL DEFAULT 0
);


INSERT INTO sys_role (id, role_code, role_name, remark, deleted) VALUES
    (1, 'ADMIN', 'Administrator', 'Current baseline super admin role', 0),
    (2, 'TEACHER', 'Teacher', 'Reserved role for exam operation and grading', 0);

INSERT INTO sys_user (id, username, password, nickname, role_code, status, deleted) VALUES
    (1, 'admin', '{noop}admin123', 'Factory Admin', 'ADMIN', 1, 0),
    (2, 'teacher', '{noop}teacher123', 'Exam Teacher', 'TEACHER', 1, 0);

INSERT INTO sys_menu (id, name, path, component, icon, permission_code, parent_id, sort_no, menu_type, deleted) VALUES
    (1, 'Dashboard', '/dashboard', 'dashboard/DashboardView', 'Odometer', 'dashboard:view', 0, 1, 'MENU', 0),
    (2, 'System', '/system', '', 'Setting', 'system:view', 0, 2, 'MENU', 0),
    (3, 'Users', '/system/users', 'system/UserView', 'User', 'sys:user:view', 2, 1, 'PAGE', 0),
    (4, 'Roles', '/system/roles', 'system/RoleView', 'Collection', 'sys:role:view', 2, 2, 'PAGE', 0),
    (5, 'Menus', '/system/menus', 'system/MenuView', 'Menu', 'sys:menu:view', 2, 3, 'PAGE', 0),
    (6, 'Exam Notices', '/notices', 'notices/NoticeView', 'Bell', 'biz:notice:view', 0, 3, 'MENU', 0),
    (7, 'Exam Core', '/exam', '', 'Reading', 'exam:view', 0, 4, 'MENU', 0),
    (8, 'Question Bank', '/exam/questions', 'exam/QuestionBankView', 'Document', 'exam:question:view', 7, 1, 'PAGE', 0),
    (9, 'Exam Papers', '/exam/papers', 'exam/ExamPaperView', 'Collection', 'exam:paper:view', 7, 2, 'PAGE', 0),
    (10, 'Exam Records', '/exam/records', 'exam/ExamRecordView', 'Histogram', 'exam:record:view', 7, 3, 'PAGE', 0);

INSERT INTO biz_notice (id, title, category, status, content, deleted) VALUES
    (1, 'Exam baseline ready', 'platform', 1, 'The exam-system template now provides reusable question, paper, and result flows.', 0),
    (2, 'Current focus', 'planning', 1, 'The continuation run deepens exam preparation and result management around the shared admin base.', 0);

INSERT INTO biz_question_bank (id, subject, question_type, difficulty_level, stem, answer_key, status, deleted) VALUES
    (1, 'Java Web', 'Single Choice', 'Medium', 'Which annotation declares a Spring MVC controller?', '@Controller', 1, 0),
    (2, 'Database', 'Short Answer', 'Hard', 'Explain the difference between clustered and non-clustered indexes.', 'Structured explanation required', 1, 0);

INSERT INTO biz_exam_paper (id, paper_name, course_name, duration_minutes, total_score, publish_status, deleted) VALUES
    (1, 'Java Web Midterm', 'Java Web', 90, 100, 1, 0),
    (2, 'Database Final Review', 'Database', 120, 100, 0, 0);

INSERT INTO biz_exam_record (id, student_name, paper_name, attempt_date, score_value, status, deleted) VALUES
    (1, 'Li Hua', 'Java Web Midterm', DATE '2024-04-18', 87.5, 1, 0),
    (2, 'Wang Yue', 'Java Web Midterm', DATE '2024-04-18', 92.0, 1, 0);
