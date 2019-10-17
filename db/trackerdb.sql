-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema trackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `trackerdb` ;

-- -----------------------------------------------------
-- Schema trackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trackerdb` DEFAULT CHARACTER SET utf8 ;
USE `trackerdb` ;

-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `site_url` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cohort`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cohort` ;

CREATE TABLE IF NOT EXISTS `cohort` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `name` VARCHAR(16) NULL,
  `nickname` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `password` VARCHAR(200) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'User',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student` ;

CREATE TABLE IF NOT EXISTS `student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `cohort_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `github_username` VARCHAR(200) NULL,
  `is_vettec` TINYINT NULL,
  `is_gi_bill` TINYINT NULL,
  `is_employed` TINYINT NULL DEFAULT 0,
  `is_accepted` TINYINT NULL,
  `deposit_paid` TINYINT NULL,
  `needs_loaner_laptop` TINYINT NULL,
  `education_level` VARCHAR(45) NULL,
  `open_to_relocation` TINYINT NULL,
  `clearance` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_cohort1_idx` (`cohort_id` ASC),
  INDEX `fk_student_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_student_cohort1`
    FOREIGN KEY (`cohort_id`)
    REFERENCES `cohort` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `application` ;

CREATE TABLE IF NOT EXISTS `application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  `position` VARCHAR(400) NULL,
  `desc_url` TEXT NULL,
  `interest_level` TINYINT(5) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_application_company1_idx` (`company_id` ASC),
  INDEX `fk_application_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_application_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `progress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `progress` ;

CREATE TABLE IF NOT EXISTS `progress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `application_id` INT NOT NULL,
  `state` VARCHAR(45) NULL DEFAULT 'Not Applied',
  `updated` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_progress_application1_idx` (`application_id` ASC),
  CONSTRAINT `fk_progress_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contact` ;

CREATE TABLE IF NOT EXISTS `contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `application_id` INT NOT NULL,
  `name` VARCHAR(300) NOT NULL,
  `email` VARCHAR(300) NULL,
  `phone` INT NULL,
  `position` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contact_application1_idx` (`application_id` ASC),
  CONSTRAINT `fk_contact_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `application_note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `application_note` ;

CREATE TABLE IF NOT EXISTS `application_note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `application_id` INT NOT NULL,
  `title` VARCHAR(200) NULL,
  `body` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notes_user_idx` (`application_id` ASC),
  CONSTRAINT `fk_notes_user`
    FOREIGN KEY (`application_id`)
    REFERENCES `application` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `job_post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_post` ;

CREATE TABLE IF NOT EXISTS `job_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NOT NULL,
  `position` VARCHAR(200) NOT NULL,
  `description` TEXT NOT NULL,
  `post_url` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_job_post_company1_idx` (`company_id` ASC),
  CONSTRAINT `fk_job_post_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `title` VARCHAR(200) NULL,
  `description` TEXT NULL,
  `location` VARCHAR(200) NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_event_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student_address` ;

CREATE TABLE IF NOT EXISTS `student_address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `street` VARCHAR(200) NULL,
  `city` VARCHAR(100) NULL,
  `state` CHAR(2) NULL,
  `zip` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `address_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contact_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_contact_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company_location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company_location` ;

CREATE TABLE IF NOT EXISTS `company_location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `state` CHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_company_location_company_idx` (`company_id` ASC),
  CONSTRAINT `fk_company_location_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company_note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company_note` ;

CREATE TABLE IF NOT EXISTS `company_note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `title` VARCHAR(200) NULL,
  `body` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notes_user_idx` (`student_id` ASC),
  INDEX `fk_company_notes_company_idx` (`company_id` ASC),
  CONSTRAINT `fk_company_notes_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_company_notes_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_desired_location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student_desired_location` ;

CREATE TABLE IF NOT EXISTS `student_desired_location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `city` VARCHAR(200) NULL,
  `state` CHAR(2) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_desired_location_student_idx` (`student_id` ASC),
  CONSTRAINT `fk_desired_location_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS trackerdb@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'trackerdb'@'localhost' IDENTIFIED BY 'tracker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'trackerdb'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `company`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `company` (`id`, `name`, `site_url`) VALUES (1, 'Fake Company', 'www.fakecomp.com');
INSERT INTO `company` (`id`, `name`, `site_url`) VALUES (2, 'Other Company', 'www.othecomp.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cohort`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `cohort` (`id`, `start_date`, `end_date`, `name`, `nickname`) VALUES (22, '2019-07-09', '2019-10-28', NULL, NULL);
INSERT INTO `cohort` (`id`, `start_date`, `end_date`, `name`, `nickname`) VALUES (23, '2019-09-22', '2019-01-10', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `user` (`id`, `enabled`, `password`, `username`, `role`) VALUES (1, 1, 'test', 'test', 'USER');
INSERT INTO `user` (`id`, `enabled`, `password`, `username`, `role`) VALUES (2, 1, 'test', 'user', 'USER');
INSERT INTO `user` (`id`, `enabled`, `password`, `username`, `role`) VALUES (3, 1, 'test', 'admin', 'ADMIN');
INSERT INTO `user` (`id`, `enabled`, `password`, `username`, `role`) VALUES (4, 1, 'test', 'guy', 'USER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `student`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `student` (`id`, `user_id`, `cohort_id`, `first_name`, `last_name`, `email`, `github_username`, `is_vettec`, `is_gi_bill`, `is_employed`, `is_accepted`, `deposit_paid`, `needs_loaner_laptop`, `education_level`, `open_to_relocation`, `clearance`) VALUES (1, 1, 22, 'Test', 'User', 'stu1@test.com', 'gituser', 1, 0, 0, 1, 1, 1, 'High School', 1, 'Secret');
INSERT INTO `student` (`id`, `user_id`, `cohort_id`, `first_name`, `last_name`, `email`, `github_username`, `is_vettec`, `is_gi_bill`, `is_employed`, `is_accepted`, `deposit_paid`, `needs_loaner_laptop`, `education_level`, `open_to_relocation`, `clearance`) VALUES (2, 2, 22, 'Other', 'Student', 'stu2@test.com', 'gitguy', 0, 1, 1, 1, 1, 0, 'Bachelors', 0, 'None');
INSERT INTO `student` (`id`, `user_id`, `cohort_id`, `first_name`, `last_name`, `email`, `github_username`, `is_vettec`, `is_gi_bill`, `is_employed`, `is_accepted`, `deposit_paid`, `needs_loaner_laptop`, `education_level`, `open_to_relocation`, `clearance`) VALUES (3, 4, 23, 'New', 'Guy', 'stu3@test.com', NULL, 1, 0, 0, 1, 1, 1, 'Associate', 1, 'None');

COMMIT;


-- -----------------------------------------------------
-- Data for table `application`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `application` (`id`, `company_id`, `student_id`, `position`, `desc_url`, `interest_level`) VALUES (1, 1, 1, 'Dev', 'www.desc.com', 3);
INSERT INTO `application` (`id`, `company_id`, `student_id`, `position`, `desc_url`, `interest_level`) VALUES (2, 2, 1, 'Jr Dev', 'www.test.com', 5);
INSERT INTO `application` (`id`, `company_id`, `student_id`, `position`, `desc_url`, `interest_level`) VALUES (3, 1, 2, 'Dev', 'www.jobapp.com', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `progress`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `progress` (`id`, `application_id`, `state`, `updated`) VALUES (1, 1, 'Applied', '2019-10-24');
INSERT INTO `progress` (`id`, `application_id`, `state`, `updated`) VALUES (2, 2, 'Applied', '2019-10-28');
INSERT INTO `progress` (`id`, `application_id`, `state`, `updated`) VALUES (3, 3, 'Not Applied', '2019-10-22');
INSERT INTO `progress` (`id`, `application_id`, `state`, `updated`) VALUES (4, 1, 'Phone Interview', '2019-10-26');
INSERT INTO `progress` (`id`, `application_id`, `state`, `updated`) VALUES (5, 3, 'Applied', '2019-10-23');

COMMIT;


-- -----------------------------------------------------
-- Data for table `contact`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `contact` (`id`, `application_id`, `name`, `email`, `phone`, `position`) VALUES (1, 1, 'contact name', 'contact@test.com', 888-888-8888, 'tech lead');
INSERT INTO `contact` (`id`, `application_id`, `name`, `email`, `phone`, `position`) VALUES (2, 3, 'other contact', 'othercon@test.com', 999-999-9999, 'hr');

COMMIT;


-- -----------------------------------------------------
-- Data for table `application_note`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `application_note` (`id`, `application_id`, `title`, `body`) VALUES (1, 1, 'Main Notes', 'I need a job');
INSERT INTO `application_note` (`id`, `application_id`, `title`, `body`) VALUES (2, 1, 'company info', 'this is a great company');
INSERT INTO `application_note` (`id`, `application_id`, `title`, `body`) VALUES (3, 2, 'company notes', 'good company');
INSERT INTO `application_note` (`id`, `application_id`, `title`, `body`) VALUES (4, 2, 'Random thoughts', 'ijvhbjfijbej in. fvjidfnvnj vfklnjnke fd ');

COMMIT;


-- -----------------------------------------------------
-- Data for table `job_post`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `job_post` (`id`, `company_id`, `position`, `description`, `post_url`) VALUES (1, 1, 'Dev', 'dev stuff', 'www.indeed.com');
INSERT INTO `job_post` (`id`, `company_id`, `position`, `description`, `post_url`) VALUES (2, 1, 'Sr Dev', 'big boy stuff', 'www.dice.com');
INSERT INTO `job_post` (`id`, `company_id`, `position`, `description`, `post_url`) VALUES (3, 2, 'Jr Dev', 'scrub stuff', 'www.linkedin/jobs.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `event` (`id`, `student_id`, `title`, `description`, `location`, `date`) VALUES (1, 1, 'test ev1', 'test1', 'somewhere', '2019-10-29 07:00');
INSERT INTO `event` (`id`, `student_id`, `title`, `description`, `location`, `date`) VALUES (2, 1, 'test ev2', 'test2', 'somewhere else', '2019-10-20 04:30');
INSERT INTO `event` (`id`, `student_id`, `title`, `description`, `location`, `date`) VALUES (3, 2, 'test ev3', 'test3', 'here', '2019-10-21 06:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `student_address`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `student_address` (`id`, `student_id`, `street`, `city`, `state`, `zip`, `phone`, `address_type`) VALUES (1, 1, '123 Student St', 'Denver', 'CO', '80202', '111-111-1111', 'Home');
INSERT INTO `student_address` (`id`, `student_id`, `street`, `city`, `state`, `zip`, `phone`, `address_type`) VALUES (2, 1, '456 Home Rd', 'Denver', 'CO', '80204', '222-222-2222', 'Home');
INSERT INTO `student_address` (`id`, `student_id`, `street`, `city`, `state`, `zip`, `phone`, `address_type`) VALUES (3, 2, '789 Other Ln', 'Texas', 'TX', '80206', '333-333-3333', 'Home');

COMMIT;


-- -----------------------------------------------------
-- Data for table `company_location`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `company_location` (`id`, `company_id`, `city`, `state`) VALUES (1, 1, 'Denver', 'CO');
INSERT INTO `company_location` (`id`, `company_id`, `city`, `state`) VALUES (2, 2, 'Denver', 'CO');

COMMIT;


-- -----------------------------------------------------
-- Data for table `company_note`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `company_note` (`id`, `student_id`, `company_id`, `title`, `body`) VALUES (1, 1, 1, 'Company Note', 'wqr wer r qwrweq r we r wer wqerqwer. qwe r qwr we rqw er qwe r ewr qwer w erwqerwq re ');
INSERT INTO `company_note` (`id`, `student_id`, `company_id`, `title`, `body`) VALUES (2, 1, 2, 'Comp2 Note', 'bnmbnm bnmb nbm nnmb mb b nmb nbmbmn mb mn bmn mbnb bmn bmnb mnb mb mnb m. nmbnbmb bmnb mnbbmnbmnbnmb mnb mb nbm nbmnbm nmb nb nmb bnmbmnb mnbmb nmbnmb mnbnmb mnb mn');
INSERT INTO `company_note` (`id`, `student_id`, `company_id`, `title`, `body`) VALUES (3, 2, 1, 'My Note', 'drgdr rdg rd gdrg drg rdgrgdrd gdr. grdrgdrgdrg rdrg drgdrgdrg drg gd gdr g drg rgrgddgdr gr grrgd rg rgdrg rg rg grgdrgrg rgdrgd g rgr g');

COMMIT;

