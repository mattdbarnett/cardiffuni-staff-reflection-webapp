-- Preset data for database --

INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Lead', 'Leading activity');

-- Dummy data for database --


INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions, isActive)
VALUES('k@aren.com', 'loveJOB', 'karen', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions,isActive)
VALUES('big@ceo.org.uk', 'bigboss', 'dave', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions,isActive)
VALUES('admin@emailexample.com', 'pass', 'admin', 'ROLE_ADMIN', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions, isActive)
VALUES('user@name', 'passw', 'user', 'ROLE_USER', 1);


