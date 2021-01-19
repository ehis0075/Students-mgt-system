DROP USER IF EXISTS 'testuser'@'localhost';
CREATE USER  'petuser'@'localhost' IDENTIFIED BY 'testuser123';
GRANT ALL PRIVILEGES ON testttt.* TO 'testuser'@'localhost';


DROP DATABASE IF EXISTS testttt;

CREATE SCHEMA IF NOT EXISTS `testttt` DEFAULT CHARACTER SET latin1 ;

-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testttt`.`app_user` ;

CREATE TABLE IF NOT EXISTS `testttt`.`app_user` (
                                                    `id` INT(11) NOT NULL,
                                                    `username` VARCHAR(20) NULL DEFAULT NULL,
                                                    `password` VARCHAR(100) NULL DEFAULT NULL,
                                                    `role` VARCHAR(100) NULL DEFAULT NULL,
                                                    PRIMARY KEY (`id`)
                                                )
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;

