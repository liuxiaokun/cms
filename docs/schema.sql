SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT;
SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS;
SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION;
SET NAMES utf8;
SET @OLD_TIME_ZONE=@@TIME_ZONE;
SET TIME_ZONE='+00:00';
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0;


-- -----------------------------------------------------
-- Schema cms_core
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cms_core` ;
CREATE SCHEMA IF NOT EXISTS `cms_core` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Schema cms_log
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cms_log` ;
CREATE SCHEMA IF NOT EXISTS `cms_log` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;


-- -----------------------------------------------------
-- Table `cms_core`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cms_core`.`user` ;

CREATE TABLE IF NOT EXISTS `cms_core`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(255) NOT NULL,
  `avatar` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL,
  `mobile` CHAR(11) NULL,
  `password` CHAR(32) NOT NULL,
  `salt` CHAR(6) NOT NULL,
  `is_email_verified` TINYINT(1) NOT NULL DEFAULT 0,
  `is_mobile_verified` TINYINT(1) NOT NULL DEFAULT 0,
  `client_ip` BIGINT NOT NULL DEFAULT 0,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL,
  `last_login` TIMESTAMP NULL DEFAULT NULL,
  `last_ip` BIGINT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cms_core`.`content`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cms_core`.`content` ;

CREATE TABLE IF NOT EXISTS `cms_core`.`content` (
  `content_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  `title` VARCHAR(32) NOT NULL,
  `content` TEXT NULL,
  `description` TEXT NULL,
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `sort_order` INT NOT NULL DEFAULT 0,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cms_core`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cms_core`.`category` ;

CREATE TABLE IF NOT EXISTS `cms_core`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `parent_id` INT NOT NULL DEFAULT 0,
  `name` VARCHAR(64) NOT NULL,
  `description` TEXT NULL,
  `icon` VARCHAR(255) NULL,
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cms_core`.`media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cms_core`.`media` ;

CREATE TABLE IF NOT EXISTS `cms_core`.`media` (
  `media_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `entity_type_id` TINYINT UNSIGNED NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`media_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `cms_core`.`content_media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cms_core`.`content_media` ;

CREATE TABLE IF NOT EXISTS `cms_core`.`content_media` (
  `content_id` INT NOT NULL,
  `media_id` BIGINT UNSIGNED NOT NULL,
  `is_cover` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`content_id`, `media_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



