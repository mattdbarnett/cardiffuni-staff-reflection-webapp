-- Preset data for database --

INSERT INTO `develomenttoolkit`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `develomenttoolkit`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `develomenttoolkit`.`role` VALUES ( 'Lead', 'Leading activity');

-- Dummy data for database --


INSERT INTO `develomenttoolkit`.`siteUser`( emailAddress, password, userName, permissions)
VALUES('k@aren.com', 'loveMYjob', 'Karen', 'ROLE_USER');

INSERT INTO `develomenttoolkit`.`siteUser`( emailAddress, password, userName, permissions)
VALUES('big@ceo.org.uk', 'BIGboss123', 'Dave', 'ROLE_USER');

INSERT INTO `develomenttoolkit`.`siteUser`(emailAddress, password, userName, permissions)
VALUES('admin@emailexample.com', 'pass', 'admin', 'ROLE_ADMIN');

INSERT INTO `develomenttoolkit`.`siteUser`(emailAddress, password, userName, permissions)
VALUES('user@name', 'password1', 'user', 'ROLE_USER');


