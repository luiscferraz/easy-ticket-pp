-- MySQL Script generated by MySQL Workbench
-- 06/03/14 14:39:42
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema easyticketweb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema easyticketpp
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `easyticketpp` ;
CREATE SCHEMA IF NOT EXISTS `easyticketpp` DEFAULT CHARACTER SET latin1 ;
SHOW WARNINGS;
USE `easyticketpp` ;

-- -----------------------------------------------------
-- Table `cargos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cargos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cargos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `cargos` (`id` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `nome_UNIQUE` ON `cargos` (`nome` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `idcursos_UNIQUE` ON `cursos` (`id` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `nome_UNIQUE` ON `cursos` (`nome` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `funcionarios` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(13) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT '',
  `idCargoFuncionario` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `funcionarios` (`id` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `cpf_UNIQUE` ON `funcionarios` (`cpf` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `alunos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alunos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `alunos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(13) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `idCursoAluno` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `alunos` (`id` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `cpf_UNIQUE` ON `alunos` (`cpf` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cartoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cartoes` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cartoes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  `saldo` FLOAT NOT NULL DEFAULT 0,
  `idAlunoCartao` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `cartoes` (`id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `recargas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recargas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `recargas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataRecarga` DATETIME NOT NULL,
  `valor` FLOAT NOT NULL,
  `idCartaoRecarga` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `recargas` (`id` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;