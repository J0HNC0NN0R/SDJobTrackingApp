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
  `name` VARCHAR(200) NULL,
  `site_url` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `status` ;

CREATE TABLE IF NOT EXISTS `status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `statuscol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `application` ;

CREATE TABLE IF NOT EXISTS `application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(400) NULL,
  `desc_url` TEXT NULL,
  `date_applied` DATE NULL,
  `interest_level` ENUM('Low', 'Medium', 'High') NULL,
  `user_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_application_user1_idx` (`user_id` ASC),
  INDEX `fk_application_status1_idx` (`status_id` ASC),
  INDEX `fk_application_company1_idx` (`company_id` ASC),
  CONSTRAINT `fk_application_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `progress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `progress` ;

CREATE TABLE IF NOT EXISTS `progress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(45) NULL,
  `status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_progress_status1_idx` (`status_id` ASC),
  CONSTRAINT `fk_progress_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contact` ;

CREATE TABLE IF NOT EXISTS `contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NULL,
  `email` VARCHAR(300) NULL,
  `phone` INT NULL,
  `position` VARCHAR(150) NULL,
  `application_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contact_application1_idx` (`application_id` ASC),
  CONSTRAINT `fk_contact_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notes` ;

CREATE TABLE IF NOT EXISTS `notes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `body` TEXT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notes_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_notes_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
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
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`) VALUES (1, 'Test', 'User', 'test@test.com');

COMMIT;

