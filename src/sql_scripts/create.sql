SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema webforum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema webforum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webforum` DEFAULT CHARACTER SET utf8 ;
USE `webforum` ;

-- -----------------------------------------------------
-- Table `webforum`.`sections`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webforum`.`sections` (
  `sectionId` INT(11) NOT NULL,
  `sectionName` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`sectionId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `webforum`.`topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webforum`.`topic` (
  `topicId` INT(11) NOT NULL,
  `sectionId` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(500) NULL DEFAULT NULL,
  `description` VARCHAR(3000) NULL DEFAULT NULL,
  PRIMARY KEY (`topicId`),
  INDEX `sectionId_idx` (`sectionId` ASC),
  CONSTRAINT `sectionIdForeignKey`
    FOREIGN KEY (`sectionId`)
    REFERENCES `webforum`.`sections` (`sectionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `webforum`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webforum`.`user` (
  `userId` INT(11) NOT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NULL DEFAULT NULL,
  `avatarUrl` VARCHAR(200) NULL DEFAULT NULL,
  `description` VARCHAR(1000) NULL DEFAULT NULL,
  `registrationDate` DATETIME NOT NULL,
  `login` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `isModerator` TINYINT(4) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `webforum`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webforum`.`messages` (
  `messageId` INT(11) NOT NULL,
  `authorId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  `content` VARCHAR(3000) NOT NULL,
  `sendDate` DATETIME NOT NULL,
  `filesUrl` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`messageId`),
  INDEX `topicIdForeignKey_idx` (`topicId` ASC),
  INDEX `userIdForeignKey_idx` (`authorId` ASC),
  CONSTRAINT `topicIdForeignKey`
    FOREIGN KEY (`topicId`)
    REFERENCES `webforum`.`topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `userIdForeignKey`
    FOREIGN KEY (`authorId`)
    REFERENCES `webforum`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
