-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `location` VARCHAR(100) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `skill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `challenge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `challenge` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `challenge` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `creator_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `name` VARCHAR(45) NULL,
  `challenger_won` TINYINT NULL DEFAULT 0,
  `location` VARCHAR(100) NULL,
  `time_created` DATETIME NOT NULL,
  `wager` INT NULL,
  `skill_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_to_user_idx` (`creator_id` ASC),
  INDEX `skill_id_to_skill_idx` (`skill_id` ASC),
  CONSTRAINT `creator_id_to_user`
    FOREIGN KEY (`creator_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `skill_id_in_chall_to_skill`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `user_skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_skill` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user_skill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `skill_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `points` INT NULL,
  INDEX `user_id_to_user_idx` (`user_id` ASC),
  INDEX `category_id_to_category_idx` (`skill_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `user_id_to_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `skill_id_to_skill`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `challenge_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `challenge_tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `challenge_tag` (
  `tag_id` INT NOT NULL,
  `challenge_id` INT NOT NULL,
  INDEX `challenge_id_to_challenge_idx` (`challenge_id` ASC),
  INDEX `tag_id_to_tag_idx` (`tag_id` ASC),
  CONSTRAINT `challenge_id_to_challenge`
    FOREIGN KEY (`challenge_id`)
    REFERENCES `challenge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tag_id_to_tag`
    FOREIGN KEY (`tag_id`)
    REFERENCES `tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sender_id` INT NOT NULL,
  `receiver_id` INT NOT NULL,
  `message` TEXT NULL,
  `time_sent` TIMESTAMP NULL,
  `thread_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `sender_id_to_user_id_idx` (`sender_id` ASC),
  INDEX `reciever_id_to_user_id_idx` (`receiver_id` ASC),
  CONSTRAINT `sender_id_to_user_id`
    FOREIGN KEY (`sender_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `reciever_id_to_user_id`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `user_challenge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_challenge` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user_challenge` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `challenge_id` INT NOT NULL,
  `invited_user_id` INT NOT NULL,
  `accepted` TINYINT NULL DEFAULT 0,
  `accept_time` TIMESTAMP NULL,
  `completed` TINYINT NULL DEFAULT 0,
  `acceptor_won` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `challenge_id_to_challenge_idx` (`challenge_id` ASC),
  INDEX `acceptor_id_to_user_idx` (`invited_user_id` ASC),
  CONSTRAINT `challenge_tag_id_to_challenge`
    FOREIGN KEY (`challenge_id`)
    REFERENCES `challenge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `acceptor_id_to_user`
    FOREIGN KEY (`invited_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
SET SQL_MODE = '';
GRANT USAGE ON *.* TO challengeUser;
 DROP USER challengeUser;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
SHOW WARNINGS;
CREATE USER 'challengeUser' IDENTIFIED BY 'challenge';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'challengeUser';
SHOW WARNINGS;
SET SQL_MODE = '';
GRANT USAGE ON *.* TO challengeAdmin;
 DROP USER challengeAdmin;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
SHOW WARNINGS;
CREATE USER 'challengeAdmin' IDENTIFIED BY 'challenge';

GRANT ALL ON * TO 'challengeAdmin';
SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
