-- MySQL Script generated by MySQL Workbench
-- Sun Nov 22 20:59:33 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema staffdevelopment
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema staffdevelopment
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS developmenttoolkit;
USE developmenttoolkit ;

DROP TABLE IF EXISTS participation;
DROP TABLE IF EXISTS reflection;
DROP TABLE IF EXISTS objective;
DROP TABLE IF EXISTS activity;
DROP TABLE IF EXISTS siteUser;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS role;



-- -----------------------------------------------------
-- Table `developmenttoolkit`.`activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS activity(
  activityID INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  file VARCHAR(45) NULL DEFAULT NULL,
  description VARCHAR(250) NULL DEFAULT NULL,
  isOfficial BOOLEAN,
  PRIMARY KEY (activityID))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `developmenttoolkit`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tag(
  tagID INT NOT NULL AUTO_INCREMENT,
  tagName VARCHAR(30) NULL DEFAULT NULL,
  description VARCHAR(200) NULL DEFAULT NULL,
  isOfficial TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`tagID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `developmenttoolkit`.`objective`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS objective(
  objectiveID INT(11) NOT NULL AUTO_INCREMENT,
  Activity_activityID INT(11) NOT NULL,
  Tag_tagID INT(11) NOT NULL,
  PRIMARY KEY (objectiveID),
    FOREIGN KEY (Activity_activityID)
    REFERENCES activity (activityID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`Tag_tagID`)
    REFERENCES tag (tagID)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `developmenttoolkit`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS role(
--  `roleID` INT(11) NOT NULL AUTO_INCREMENT,
--   `type` VARCHAR(45) NOT NULL DEFAULT NULL,
  role VARCHAR(45) NOT NULL,
  description VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (role))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `developmenttoolkit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS siteUser(
  userID INT(11) NOT NULL AUTO_INCREMENT,
  emailAddress VARCHAR(45) NOT NULL,
  password VARCHAR(100)NOT NULL,
  userName VARCHAR(20) NULL DEFAULT NULL,
  isActive BOOLEAN NULL DEFAULT NULL,
  permissions VARCHAR(30) NOT NULL,
  PRIMARY KEY (userID))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `developmenttoolkit`.`reflection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS reflection(
   reflectionID INT(11) NOT NULL AUTO_INCREMENT,
   Participation_participationID INT(11) NOT NULL,
   Tag_tagID INT(11) NOT NULL,
   Reflect_what VARCHAR(200),
   Reflect_prompt VARCHAR(200),
   Reflect_happen VARCHAR(200),
   Reflect_eval VARCHAR(200),
   Reflect_diff VARCHAR(200),
   Reflect_lp VARCHAR(200),
   isPublic BOOLEAN,
   rating INT(11),
   PRIMARY KEY (reflectionID),
   FOREIGN KEY (Tag_tagID)
       REFERENCES tag (tagID)
       ON DELETE CASCADE
       ON UPDATE CASCADE)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `developmenttoolkit`.`participation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS participation(
  participationID INT(11) NOT NULL AUTO_INCREMENT,
  date DATETIME NULL DEFAULT NULL,
  siteUser_userID INT(11) NOT NULL,
  Activity_activityID INT(11) NOT NULL,
  Role_roleID VARCHAR(45) NOT NULL,
  PRIMARY KEY (participationID),
    FOREIGN KEY (Activity_activityID)
    REFERENCES activity (activityID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (siteUser_userID)
    REFERENCES siteUser (userID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (Role_roleID)
    REFERENCES role (role)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE USER IF NOT EXISTS 'siteUser'@'localhost' IDENTIFIED BY '99Reflections!' PASSWORD EXPIRE INTERVAL 120 DAY;
GRANT INSERT, UPDATE, DELETE, SELECT ON developmenttoolkit.siteUser TO 'siteUser'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON developmenttoolkit.activity TO 'siteUser'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON developmenttoolkit.tag TO 'siteUser'@'localhost';
GRANT INSERT, UPDATE, SELECT ON developmenttoolkit.objective TO 'siteUser'@'localhost';
GRANT INSERT, UPDATE, SELECT ON developmenttoolkit.role TO 'siteUser'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON developmenttoolkit.reflection TO 'siteUser'@'localhost';
GRANT INSERT, UPDATE, DELETE, SELECT ON developmenttoolkit.participation TO 'siteUser'@'localhost';

-- -----------------------------------------------------
-- Triggers
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Participation Insert
-----------------------------------------------------
-- DROP TRIGGER IF EXISTS part_insert;
--  DELIMITER $$
--  CREATE TRIGGER part_insert BEFORE INSERT
--  ON participation
--  FOR EACH ROW
--  	BEGIN
--  		DECLARE partActID INT;
--         DECLARE checkActID INT;
--  		SET partActID = NEW.Activity_activityID;
--         SET checkActID = (SELECT EXISTS(SELECT activityID FROM activity WHERE activityID = partActID));
--         IF (checkActID != partActID) THEN
--  			INSERT INTO activity (activityID, name, file, description, isOfficial) VALUES (partActID, "Placeholder Activity", "Placeholder URL", "Placeholder Description", false);
--  		END IF;
--  	END$$
-- DELIMITER ;

-- -----------------------------------------------------
-- Activity Insert
-- -----------------------------------------------------
DROP TRIGGER IF EXISTS reflect_insert;
DELIMITER $$
CREATE TRIGGER reflect_insert BEFORE INSERT
ON reflection
FOR EACH ROW
	BEGIN
		DECLARE reflectPartID INT;
        DECLARE checkPartID INT;
        DECLARE checkActID INT;
		SET reflectPartID = NEW.Participation_participationID;
        SET checkActID = (SELECT EXISTS(SELECT participationID FROM participation WHERE participationID = reflectPartID));
        IF (reflectPartID != checkPartID) THEN
			INSERT INTO activity (activityID, name, file, description, isOfficial) VALUES (null, "Placeholder Activity", "Placeholder URL", "Placeholder Description", false);
            SET checkActID = (SELECT activityID FROM participation WHERE name = "Placeholder Activity");
            INSERT INTO participation (participationID, date, siteUser_activityID, Activity_activityID, Role_roleID) VALUES (null, null, 0, checkActID, "USER");
		END IF;
	END$$
DELIMITER ;


-- -----------------------------------------------------
-- PROCEDURES
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Add Activity Procedure
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS add_activity;
DELIMITER //
CREATE PROCEDURE add_activity(
IN activityID INT,
IN  name VARCHAR(45),
IN  file VARCHAR(45),
IN  description VARCHAR(250),
IN  isOfficial BOOLEAN
)
	BEGIN
		DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN
			ROLLBACK;
			SELECT "Transaction has been rolled back as table does not exist" as Message;
		END;
		
		DECLARE EXIT HANDLER FOR 1062
			BEGIN
				ROLLBACK;
				SELECT CONCAT('Duplicate key (',activityID,') occurred') AS message;
			END;
     
		START TRANSACTION;
            INSERT INTO activity (activityID, name, file, description, isOfficial)
            VALUES (activityID, name, file, description, isOfficial);
			COMMIT;
    END //
DELIMITER ;  