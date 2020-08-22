-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema arac_alisveris
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema arac_alisveris
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `arac_alisveris` DEFAULT CHARACTER SET utf8 ;
USE `arac_alisveris` ;

-- -----------------------------------------------------
-- Table `arac_alisveris`.`Tbl_Sehir`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arac_alisveris`.`Tbl_Sehir` (
  `SehirID` INT NOT NULL AUTO_INCREMENT,
  `Sehir` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`SehirID`),
  UNIQUE INDEX `SehirID_UNIQUE` (`SehirID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arac_alisveris`.`Tbl_Renk`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arac_alisveris`.`Tbl_Renk` (
  `RenkID` INT NOT NULL AUTO_INCREMENT,
  `Renk` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`RenkID`),
  UNIQUE INDEX `RenkID_UNIQUE` (`RenkID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arac_alisveris`.`Tbl_YakitTuru`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arac_alisveris`.`Tbl_YakitTuru` (
  `YakitTuruID` INT NOT NULL AUTO_INCREMENT,
  `Yakit_Turu` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`YakitTuruID`),
  UNIQUE INDEX `YakitTuruID_UNIQUE` (`YakitTuruID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arac_alisveris`.`Tbl_VitesTuru`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arac_alisveris`.`Tbl_VitesTuru` (
  `VitesTuruID` INT NOT NULL AUTO_INCREMENT,
  `Vites_Turu` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`VitesTuruID`),
  UNIQUE INDEX `VitesTuruID_UNIQUE` (`VitesTuruID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arac_alisveris`.`Tbl_Araba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arac_alisveris`.`Tbl_Araba` (
  `ArabaID` INT NOT NULL AUTO_INCREMENT,
  `Araba_Marka` VARCHAR(45) NOT NULL,
  `Araba_Model` VARCHAR(45) NOT NULL,
  `Araba_VitesTuruID` INT DEFAULT NULL,
  `Araba_YakitTuruID` INT DEFAULT NULL,
  `Araba_RenkID` INT DEFAULT NULL,
  PRIMARY KEY (`ArabaID`),
  UNIQUE INDEX `ArabaID_UNIQUE` (`ArabaID` ASC),
  INDEX `fk_Tbl_Araba_Tbl_Renk_idx` (`Araba_RenkID` ASC),
  INDEX `fk_Tbl_Araba_Tbl_YakitTuru1_idx` (`Araba_YakitTuruID` ASC),
  INDEX `fk_Tbl_Araba_Tbl_VitesTuru1_idx` (`Araba_VitesTuruID` ASC),
  CONSTRAINT `fk_Tbl_Araba_Tbl_Renk`
    FOREIGN KEY (`Araba_RenkID`)
    REFERENCES `arac_alisveris`.`Tbl_Renk` (`RenkID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Tbl_Araba_Tbl_YakitTuru1`
    FOREIGN KEY (`Araba_YakitTuruID`)
    REFERENCES `arac_alisveris`.`Tbl_YakitTuru` (`YakitTuruID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Tbl_Araba_Tbl_VitesTuru1`
    FOREIGN KEY (`Araba_VitesTuruID`)
    REFERENCES `arac_alisveris`.`Tbl_VitesTuru` (`VitesTuruID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `arac_alisveris`.`Tbl_Ilan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `arac_alisveris`.`Tbl_Ilan` (
  `IlanID` INT NOT NULL AUTO_INCREMENT,
  `Ilan_Adi` VARCHAR(75) NOT NULL,
  `Ilan_Fiyat` DECIMAL(6,3) NOT NULL,
  `Ilan_Km` DECIMAL(6,3) NOT NULL,
  `Ilan_Tarih` DATE NOT NULL,
  `Ilan_ArabaID` INT DEFAULT NULL,
  `Ilan_SehirID` INT DEFAULT NULL,
  PRIMARY KEY (`IlanID`),
  UNIQUE INDEX `IlanID_UNIQUE` (`IlanID` ASC),
  INDEX `fk_Tbl_Ilan_Tbl_Sehir1_idx` (`Ilan_SehirID` ASC),
  INDEX `fk_Tbl_Ilan_Tbl_Araba1_idx` (`Ilan_ArabaID` ASC),
  CONSTRAINT `fk_Tbl_Ilan_Tbl_Sehir1`
    FOREIGN KEY (`Ilan_SehirID`)
    REFERENCES `arac_alisveris`.`Tbl_Sehir` (`SehirID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Tbl_Ilan_Tbl_Araba1`
    FOREIGN KEY (`Ilan_ArabaID`)
    REFERENCES `arac_alisveris`.`Tbl_Araba` (`ArabaID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
