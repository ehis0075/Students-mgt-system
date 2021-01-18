USE `testttt`;

SET FOREIGN_KEY_CHECKS  = 0;
TRUNCATE TABLE student;

SET FOREIGN_KEY_CHECKS  = 1;

INSERT INTO testttt.student(id, username, password, role)
VALUES (1, 'ehis', 'ehis123', 'ADMIN'),
       (1, 'ehis', 'ehis123', 'ADMIN'),
       (1, 'ehis', 'ehis123', 'ADMIN');
