-- Preset data for database --

INSERT INTO `staffdevelopment`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Lead', 'Leading activity');

-- Dummy data for database --


INSERT INTO `staffdevelopment`.`siteUser`( emailAddress, password, userName, permissions)
VALUES('k@aren.com', 'loveMYjob', 'Karen', 'ROLE_USER');

INSERT INTO `staffdevelopment`.`siteUser`( emailAddress, password, userName, permissions)
VALUES('big@ceo.org.uk', 'BIGboss123', 'Dave', 'ROLE_USER');

INSERT INTO `staffdevelopment`.`siteUser`(emailAddress, password, userName, permissions)
VALUES('bigger@ceo.org.uk', 'password1', 'Aaron', 'ROLE_ADMIN');

INSERT INTO `staffdevelopment`.`siteUser`(emailAddress, password, userName, permissions)
VALUES('user@name', 'password1', 'user', 'ROLE_USER');


