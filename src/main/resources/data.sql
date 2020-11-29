
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Lead', 'Leading activity');

-- INSERT INTO `staffdevelopment`.`siteUser`(name, homeAddress, emailAddress, position, phoneNo, Role_roleID)
-- values ( 'Karen', 'Oak Valley Road', 'sillyKaren@hotmail.co.uk', 'A test position', '123', 1);

-- INSERT INTO role VALUES(1, 'Secretary', 'Files the documents');
INSERT INTO `staffdevelopment`.`siteUser`( emailAddress, password, name)
VALUES('k@aren.com', 'loveMYjob', 'Karen');

INSERT INTO `staffdevelopment`.`siteUser`( emailAddress, password, name)
VALUES('big@ceo.org.uk', 'BIGboss123', 'Dave');

INSERT INTO `staffdevelopment`.`siteUser`(emailAddress, password, name)
VALUES('bigger@ceo.org.uk', 'password1', 'Aaron');

select * from `staffdevelopment`.`siteUser`;
