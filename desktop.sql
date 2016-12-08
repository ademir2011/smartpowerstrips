-- MySQL Script generated by MySQL Workbench
-- Dom 04 Dez 2016 14:22:51 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema powerstripsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema powerstripsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `powerstripsdb` DEFAULT CHARACTER SET utf8 ;
USE `powerstripsdb` ;

-- -----------------------------------------------------
-- Table `powerstripsdb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `powerstripsdb`.`usuarios` (
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `powerstripsdb`.`componentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `powerstripsdb`.`componentes` (
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `imageFilePath` VARCHAR(500) NULL,
  `usuario_login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nome`, `usuario_login`),
  INDEX `fk_componentes_usuarios1_idx` (`usuario_login` ASC),
  CONSTRAINT `fk_componentes_usuarios1`
    FOREIGN KEY (`usuario_login`)
    REFERENCES `powerstripsdb`.`usuarios` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `powerstripsdb`.`estatisticas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `powerstripsdb`.`estatisticas` (
  `idestatistica` INT NOT NULL AUTO_INCREMENT,
  `horario` DATETIME NULL,
  `valor` TINYINT(1) NULL,
  `componente_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestatistica`, `componente_nome`),
  INDEX `fk_estatisticas_componentes1_idx` (`componente_nome` ASC),
  CONSTRAINT `fk_estatisticas_componentes1`
    FOREIGN KEY (`componente_nome`)
    REFERENCES `powerstripsdb`.`componentes` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;