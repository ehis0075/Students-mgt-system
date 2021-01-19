USE `testttt`;

SET FOREIGN_KEY_CHECKS  = 0;
TRUNCATE TABLE app_user;

SET FOREIGN_KEY_CHECKS  = 1;

INSERT INTO testttt.app_user(id, username, password, role)
VALUES (1, 'ehis', 'ehis123', 'HOD'),
       (1, 'ehis', 'ehis123', 'STUDENT'),
       (1, 'ehis', 'ehis123', 'LECTURER');
