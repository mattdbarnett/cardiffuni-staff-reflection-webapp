-- Preset data for database --

INSERT INTO `staffdevelopment`.`permission` VALUES ( 'USER');
INSERT INTO `staffdevelopment`.`permission` VALUES ( 'ADMIN');

-- Dummy data for database --


INSERT INTO `staffdevelopment`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Lead', 'Leading activity');


INSERT INTO `staffdevelopment`.`siteUser`( emailAddress, password, username, permissions)
VALUES('k@aren.com', 'loveMYjob', 'Karen', 'ROLE_USER');

INSERT INTO `staffdevelopment`.`siteUser`( emailAddress, password, username, permissions)
VALUES('big@ceo.org.uk', 'BIGboss123', 'Dave', 'ROLE_USER');

INSERT INTO `staffdevelopment`.`siteUser`(emailAddress, password, username, permissions)
VALUES('bigger@ceo.org.uk', 'password1', 'Aaron', 'ROLE_ADMIN');


