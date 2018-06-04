-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema challengedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `challengedb` ;

-- -----------------------------------------------------
-- Schema challengedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `challengedb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `challengedb` ;

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
-- Table `status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `status` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `status` (
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
  `skill_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(100) NULL,
  `time_created` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `wager` INT NOT NULL DEFAULT 0,
  `min_number_of_challengers` INT NULL,
  `max_number_of_challengers` INT NULL,
  `expiration` DATETIME NULL,
  `description` TEXT NULL,
  `image` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_to_user_idx` (`creator_id` ASC),
  INDEX `skill_id_to_skill_idx` (`skill_id` ASC),
  INDEX `status_id_to_status_idx` (`status_id` ASC),
  CONSTRAINT `creator_id_to_user`
    FOREIGN KEY (`creator_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `skill_id_in_chall_to_skill`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `status_id_to_status`
    FOREIGN KEY (`status_id`)
    REFERENCES `status` (`id`)
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
  `time_sent` TIMESTAMP NULL DEFAULT current_timestamp,
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
  `accept_time` TIMESTAMP NULL DEFAULT current_timestamp,
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

-- -----------------------------------------------------
-- Table `user_1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_1` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user_1` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);

SHOW WARNINGS;
SET SQL_MODE = '';
GRANT USAGE ON *.* TO challengeUser@localhost;
 DROP USER challengeUser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
SHOW WARNINGS;
CREATE USER 'challengeUser'@'localhost' IDENTIFIED BY 'challenge';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'challengeUser'@'localhost';
SHOW WARNINGS;
SET SQL_MODE = '';
GRANT USAGE ON *.* TO challengeAdmin@localhost;
 DROP USER challengeAdmin@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
SHOW WARNINGS;
CREATE USER 'challengeAdmin'@'localhost' IDENTIFIED BY 'challenge';

GRANT ALL ON * TO 'challengeAdmin'@'localhost';
SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `location`, `role`) VALUES (1, 'AlexTheDestroyer', 'alex', 'alex@alex.com', 'here', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `location`, `role`) VALUES (2, 'DoraTheExplora', 'dora', 'dora@dora.com', 'here', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `location`, `role`) VALUES (3, 'EliTheHair', 'eli', 'eli@eli.com', 'here', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `location`, `role`) VALUES (4, 'AndrewTheOtherAndrew', 'andrew', 'andrew@andrew.com', 'here', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `location`, `role`) VALUES (5, 'MeganTheIncomplete', 'megan', 'megan@megan.com', 'here', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `skill` (`id`, `name`) VALUES (1, 'drinking');
INSERT INTO `skill` (`id`, `name`) VALUES (2, 'weight lifting');
INSERT INTO `skill` (`id`, `name`) VALUES (3, 'workout');
INSERT INTO `skill` (`id`, `name`) VALUES (4, 'billiards');
INSERT INTO `skill` (`id`, `name`) VALUES (5, 'ping pong');
INSERT INTO `skill` (`id`, `name`) VALUES (6, 'chess');
INSERT INTO `skill` (`id`, `name`) VALUES (7, 'darts');
INSERT INTO `skill` (`id`, `name`) VALUES (8, 'video games');
INSERT INTO `skill` (`id`, `name`) VALUES (9, 'board games');
INSERT INTO `skill` (`id`, `name`) VALUES (10, 'trivia');
INSERT INTO `skill` (`id`, `name`) VALUES (11, 'football');
INSERT INTO `skill` (`id`, `name`) VALUES (12, 'basketball');
INSERT INTO `skill` (`id`, `name`) VALUES (13, 'baseball');
INSERT INTO `skill` (`id`, `name`) VALUES (14, 'soccer');
INSERT INTO `skill` (`id`, `name`) VALUES (15, 'hockey');
INSERT INTO `skill` (`id`, `name`) VALUES (16, 'running');
INSERT INTO `skill` (`id`, `name`) VALUES (17, 'shuffleboard');
INSERT INTO `skill` (`id`, `name`) VALUES (18, 'other bar games');
INSERT INTO `skill` (`id`, `name`) VALUES (19, 'other sports');
INSERT INTO `skill` (`id`, `name`) VALUES (20, 'other games');

COMMIT;


-- -----------------------------------------------------
-- Data for table `status`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `status` (`id`, `name`) VALUES (1, 'pending');
INSERT INTO `status` (`id`, `name`) VALUES (2, 'active');
INSERT INTO `status` (`id`, `name`) VALUES (3, 'completed');
INSERT INTO `status` (`id`, `name`) VALUES (4, 'expired');

COMMIT;


-- -----------------------------------------------------
-- Data for table `challenge`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `challenge` (`id`, `creator_id`, `skill_id`, `status_id`, `name`, `location`, `time_created`, `wager`, `min_number_of_challengers`, `max_number_of_challengers`, `expiration`, `description`, `image`) VALUES (1, 1, 1, 2, 'Drinking Challenge', 'The bar', DEFAULT, DEFAULT, 2, 2, NULL, 'Drink against Me!', NULL);
INSERT INTO `challenge` (`id`, `creator_id`, `skill_id`, `status_id`, `name`, `location`, `time_created`, `wager`, `min_number_of_challengers`, `max_number_of_challengers`, `expiration`, `description`, `image`) VALUES (2, 2, 2, 1, 'Lift Me Bro', 'The gym', DEFAULT, DEFAULT, 2, 3, NULL, 'I can outlift you bro', NULL);
INSERT INTO `challenge` (`id`, `creator_id`, `skill_id`, `status_id`, `name`, `location`, `time_created`, `wager`, `min_number_of_challengers`, `max_number_of_challengers`, `expiration`, `description`, `image`) VALUES (3, 3, 3, 1, 'Crossfit', 'The gym', DEFAULT, DEFAULT, 2, 3, NULL, 'I can do more cardio than anyone with a heart', NULL);
INSERT INTO `challenge` (`id`, `creator_id`, `skill_id`, `status_id`, `name`, `location`, `time_created`, `wager`, `min_number_of_challengers`, `max_number_of_challengers`, `expiration`, `description`, `image`) VALUES (4, 4, 4, 1, '8 Ball', 'The bar', DEFAULT, DEFAULT, 2, 4, NULL, 'I\'m pretty good at pool', NULL);
INSERT INTO `challenge` (`id`, `creator_id`, `skill_id`, `status_id`, `name`, `location`, `time_created`, `wager`, `min_number_of_challengers`, `max_number_of_challengers`, `expiration`, `description`, `image`) VALUES (5, 5, 5, 3, 'Ping Pang', 'The bar', DEFAULT, DEFAULT, 2, 2, NULL, 'I wanna play someone at Ping Pong!', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tag`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `tag` (`id`, `name`) VALUES (1, 'sports');
INSERT INTO `tag` (`id`, `name`) VALUES (2, 'bar games');
INSERT INTO `tag` (`id`, `name`) VALUES (3, 'social');
INSERT INTO `tag` (`id`, `name`) VALUES (4, 'endurance');
INSERT INTO `tag` (`id`, `name`) VALUES (5, 'tabletop games');
INSERT INTO `tag` (`id`, `name`) VALUES (6, 'video games');
INSERT INTO `tag` (`id`, `name`) VALUES (7, 'brain teasers');
INSERT INTO `tag` (`id`, `name`) VALUES (8, 'outdoors');
INSERT INTO `tag` (`id`, `name`) VALUES (9, 'indoors');
INSERT INTO `tag` (`id`, `name`) VALUES (10, 'teams');
INSERT INTO `tag` (`id`, `name`) VALUES (11, 'one on one');
INSERT INTO `tag` (`id`, `name`) VALUES (12, 'physical strength');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `user_skill` (`id`, `skill_id`, `user_id`, `points`) VALUES (1, 1, 1, 5);
INSERT INTO `user_skill` (`id`, `skill_id`, `user_id`, `points`) VALUES (2, 2, 2, 7);
INSERT INTO `user_skill` (`id`, `skill_id`, `user_id`, `points`) VALUES (3, 3, 3, 15);
INSERT INTO `user_skill` (`id`, `skill_id`, `user_id`, `points`) VALUES (4, 4, 4, 18);
INSERT INTO `user_skill` (`id`, `skill_id`, `user_id`, `points`) VALUES (5, 5, 5, 9);

COMMIT;


-- -----------------------------------------------------
-- Data for table `challenge_tag`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (2, 1);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (3, 1);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (12, 2);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (4, 2);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (4, 3);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (9, 4);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (2, 4);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (2, 5);
INSERT INTO `challenge_tag` (`tag_id`, `challenge_id`) VALUES (8, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `message`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (1, 1, 2, 'Nice weightlifting bro', NULL, 1);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (2, 2, 1, 'Thx ;)', NULL, 1);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (3, 2, 3, 'How long does it take you to do your hair like that every morning?', NULL, 3);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (4, 3, 2, 'I just wake up this way', NULL, 3);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (5, 3, 4, 'Wanna smoke?', NULL, 5);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (6, 4, 3, 'You mean vape? I don\'t smoke', NULL, 5);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (7, 4, 5, 'Why is Alex so mean to me?', NULL, 7);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (8, 5, 4, 'Because he thinks you\'re cute', NULL, 7);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (9, 5, 1, 'Do you think Andrew is cute?', NULL, 9);
INSERT INTO `message` (`id`, `sender_id`, `receiver_id`, `message`, `time_sent`, `thread_id`) VALUES (10, 1, 5, 'yea', NULL, 9);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_challenge`
-- -----------------------------------------------------
START TRANSACTION;
USE `challengedb`;
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (1, 1, 1, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (2, 2, 2, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (3, 3, 3, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (4, 4, 4, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (5, 5, 5, 1, NULL, 1);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (6, 2, 1, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (7, 3, 2, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (8, 4, 3, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (9, 5, 4, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (10, 1, 5, 1, NULL, 0);
INSERT INTO `user_challenge` (`id`, `challenge_id`, `invited_user_id`, `accepted`, `accept_time`, `acceptor_won`) VALUES (11, 4, 1, 1, NULL, 0);

COMMIT;
