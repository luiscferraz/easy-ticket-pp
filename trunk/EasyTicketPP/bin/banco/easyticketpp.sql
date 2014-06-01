-- MySQL Script generated by MySQL Workbench
-- 05/27/14 15:31:17
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema easyticket
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `easyticket` ;
CREATE SCHEMA IF NOT EXISTS `easyticket` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema easyticketweb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `easyticketweb` ;
CREATE SCHEMA IF NOT EXISTS `easyticketweb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `table1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `table1` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `table1` (
)
ENGINE = InnoDB;

SHOW WARNINGS;
USE `easyticket` ;

-- -----------------------------------------------------
-- Table `cursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cursos` (
  `idCurso` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeCurso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `idCursos_UNIQUE` ON `cursos` (`idCurso` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `alunos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alunos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `alunos` (
  `idAluno` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeAluno` VARCHAR(55) NOT NULL,
  `cpfAluno` VARCHAR(14) NOT NULL,
  `emailAluno` VARCHAR(45) NOT NULL,
  `telefoneAluno` VARCHAR(13) NOT NULL,
  `dataNascimentoAluno` DATE NOT NULL,
  `statusAluno` ENUM('ATIVO','INATIVO') NOT NULL,
  `terminoCursoAluno` VARCHAR(45) NULL DEFAULT NULL,
  `idCursoAluno` INT(11) NOT NULL,
  PRIMARY KEY (`idAluno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `idAluno_UNIQUE` ON `alunos` (`idAluno` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `cpfAluno_UNIQUE` ON `alunos` (`cpfAluno` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `emailAluno_UNIQUE` ON `alunos` (`emailAluno` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cargos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cargos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cargos` (
  `idCargos` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeCargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCargos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `idCargos_UNIQUE` ON `cargos` (`idCargos` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `nomeCargo_UNIQUE` ON `cargos` (`nomeCargo` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cartoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cartoes` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cartoes` (
  `numCartao` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `statusCartao` ENUM('ATIVO','INATIVO','BLOQUEADO') NOT NULL,
  `saldoCartao` FLOAT NOT NULL DEFAULT '0',
  `idAlunoCartao` INT(11) NOT NULL,
  PRIMARY KEY (`numCartao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `funcionarios` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `idFuncionarios` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(55) NOT NULL,
  `cpfFuncionario` VARCHAR(14) NOT NULL,
  `emailFuncionario` VARCHAR(45) NOT NULL,
  `telefoneFuncionario` VARCHAR(13) NOT NULL,
  `dataNascimentoFuncionario` DATE NOT NULL,
  `statusFuncionario` ENUM('ATIVO','INATIVO') NOT NULL,
  `idCargoFuncionario` INT(11) NOT NULL,
  PRIMARY KEY (`idFuncionarios`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `idFuncionarios_UNIQUE` ON `funcionarios` (`idFuncionarios` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `cpfFuncionario_UNIQUE` ON `funcionarios` (`cpfFuncionario` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `recargas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recargas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `recargas` (
  `idRecarga` INT(10) NOT NULL AUTO_INCREMENT,
  `dataRecarga` DATETIME NOT NULL,
  `valorRecarga` FLOAT NOT NULL,
  `numCartaoRecarga` INT(11) NOT NULL,
  PRIMARY KEY (`idRecarga`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `idRecarga_UNIQUE` ON `recargas` (`idRecarga` ASC);

SHOW WARNINGS;
USE `easyticketweb` ;

-- -----------------------------------------------------
-- Table `courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `courses` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roles` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `name_UNIQUE` ON `roles` (`name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `employees` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(55) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(13) NOT NULL,
  `birthday` DATE NOT NULL,
  `login` VARCHAR(16) NOT NULL,
  `password` VARCHAR(8) NOT NULL,
  `registerDate` DATETIME NOT NULL,
  `statusEmployee` ENUM('ATIVO','INATIVO') NOT NULL,
  `idRole` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `cpf_UNIQUE` ON `employees` (`cpf` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `email_UNIQUE` ON `employees` (`email` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `login_UNIQUE` ON `employees` (`login` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `items` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `items` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `name_UNIQUE` ON `items` (`name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meals` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meals` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `menus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `menus` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `menus` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meal_has_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meal_has_menu` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meal_has_menu` (
  `idMealFk` INT(11) NOT NULL,
  `idMenuFk` INT(11) NOT NULL,
  `menuDate` DATE NOT NULL,
  PRIMARY KEY (`idMealFk`, `idMenuFk`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `idMealFk_idx` ON `meal_has_menu` (`idMealFk` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `menu_has_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `menu_has_item` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `menu_has_item` (
  `idMenu` INT(11) NOT NULL,
  `idItem` INT(11) NOT NULL,
  PRIMARY KEY (`idMenu`, `idItem`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `idMenu_idx` ON `menu_has_item` (`idMenu` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `students`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `students` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `students` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(55) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(13) NOT NULL,
  `birthday` DATE NOT NULL,
  `login` VARCHAR(16) NOT NULL,
  `password` VARCHAR(8) NOT NULL,
  `registerDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `statusStudent` ENUM('ATIVO','INATIVO') NOT NULL,
  `beginningCourse` DATE NOT NULL,
  `endCourse` DATE NOT NULL,
  `idCourse` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `cpf_UNIQUE` ON `students` (`cpf` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `email_UNIQUE` ON `students` (`email` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `login_UNIQUE` ON `students` (`login` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tickets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tickets` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tickets` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numTicket` INT(11) NOT NULL,
  `statusTicket` ENUM('ATIVO','INATIVO','BLOQUEADO') NOT NULL,
  `balance` FLOAT NOT NULL DEFAULT '0',
  `registerDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idStudent` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `payments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payments` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `payments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `value` FLOAT NOT NULL,
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idTicket` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `payment_has_meal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payment_has_meal` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `payment_has_meal` (
  `idPayment` INT(11) NOT NULL,
  `idMeal` INT(11) NOT NULL,
  `menuDate` DATE NOT NULL,
  PRIMARY KEY (`idPayment`, `idMeal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `idPayment_idx` ON `payment_has_meal` (`idPayment` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `recharges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recharges` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `recharges` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `rechargeValue` INT(11) NOT NULL,
  `rechargeDate` DATETIME NOT NULL,
  `numTicket` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- View `view1`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `view1` ;
SHOW WARNINGS;
USE `mydb`;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
