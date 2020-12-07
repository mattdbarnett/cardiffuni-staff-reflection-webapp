-- Preset data for database --

INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Lead', 'Leading activity');

-- Dummy data for database --


INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions)
VALUES('k@aren.com', 'lovethejob', 'karen', 'ROLE_USER');

INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions)
VALUES('big@ceo.org.uk', 'BIGboss123', 'dave', 'ROLE_ADMIN');

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions)
VALUES('admin@emailexample.com', 'pass', 'admin', 'ROLE_ADMIN');

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions)
VALUES('user@name', 'password1', 'user', 'ROLE_ADMIN');


