INSERT INTO sys_role (id, role_code, role_name, remark, deleted) VALUES
    (1, 'ADMIN', 'Administrator', 'Current baseline super admin role', 0),
    (2, 'LIBRARIAN', 'Librarian', 'Reserved role for library operations', 0);

INSERT INTO sys_user (id, username, password, nickname, role_code, status, deleted) VALUES
    (1, 'admin', '{noop}admin123', 'Factory Admin', 'ADMIN', 1, 0),
    (2, 'librarian', '{noop}library123', 'Library Operator', 'LIBRARIAN', 1, 0);

INSERT INTO sys_menu (id, name, path, component, icon, permission_code, parent_id, sort_no, menu_type, deleted) VALUES
    (1, 'Dashboard', '/dashboard', 'dashboard/DashboardView', 'Odometer', 'dashboard:view', 0, 1, 'MENU', 0),
    (2, 'System', '/system', '', 'Setting', 'system:view', 0, 2, 'MENU', 0),
    (3, 'Users', '/system/users', 'system/UserView', 'User', 'sys:user:view', 2, 1, 'PAGE', 0),
    (4, 'Roles', '/system/roles', 'system/RoleView', 'Collection', 'sys:role:view', 2, 2, 'PAGE', 0),
    (5, 'Menus', '/system/menus', 'system/MenuView', 'Menu', 'sys:menu:view', 2, 3, 'PAGE', 0),
    (6, 'Library Notices', '/notices', 'notices/NoticeView', 'Bell', 'biz:notice:view', 0, 3, 'MENU', 0),
    (7, 'Library Core', '/library', '', 'Reading', 'library:view', 0, 4, 'MENU', 0),
    (8, 'Book Catalog', '/library/books', 'library/BookCatalogView', 'Collection', 'library:book:view', 7, 1, 'PAGE', 0),
    (9, 'Reader Management', '/library/readers', 'library/ReaderManagementView', 'User', 'library:reader:view', 7, 2, 'PAGE', 0),
    (10, 'Borrow & Return', '/library/borrow-records', 'library/BorrowRecordView', 'Document', 'library:borrow:view', 7, 3, 'PAGE', 0);

INSERT INTO biz_notice (id, title, category, status, content, deleted) VALUES
    (1, 'Library baseline ready', 'platform', 1, 'The library-management template now provides reusable catalog, reader, and borrow flows.', 0),
    (2, 'Current focus', 'planning', 1, 'The continuation run deepens the core circulation modules around the shared admin base.', 0);

INSERT INTO biz_book_catalog (id, book_code, title, category, author, publisher, stock, status, deleted) VALUES
    (1, 'BK-1001', 'Database Systems', 'Computer Science', 'Elmasri', 'Pearson', 12, 1, 0),
    (2, 'BK-2033', 'Modern Operating Systems', 'Computer Science', 'Tanenbaum', 'Pearson', 8, 1, 0);

INSERT INTO biz_reader_profile (id, reader_no, reader_name, reader_type, phone, status, deleted) VALUES
    (1, 'R-2024-01', 'Lin Qiao', 'Student', '13810001111', 1, 0),
    (2, 'R-2024-02', 'Zhao Min', 'Teacher', '13810002222', 1, 0);

INSERT INTO biz_borrow_record (id, reader_no, reader_name, book_title, borrow_date, due_date, return_date, status, deleted) VALUES
    (1, 'R-2024-01', 'Lin Qiao', 'Database Systems', DATE '2024-04-01', DATE '2024-04-21', NULL, 0, 0),
    (2, 'R-2024-02', 'Zhao Min', 'Modern Operating Systems', DATE '2024-03-11', DATE '2024-03-31', DATE '2024-03-28', 1, 0);
