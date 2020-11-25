
INSERT INTO `staffdevelopment`.`role` VALUES ( 'Secretary', 'Files the documents etc');
INSERT INTO `staffdevelopment`.`role` VALUES ( 'CEO', 'Tells secretary what to do etc');

-- INSERT INTO `staffdevelopment`.`siteUser`(name, homeAddress, emailAddress, position, phoneNo, Role_roleID)
-- values ( 'Karen', 'Oak Valley Road', 'sillyKaren@hotmail.co.uk', 'A test position', '123', 1);

-- INSERT INTO role VALUES(1, 'Secretary', 'Files the documents');
INSERT INTO `staffdevelopment`.`siteUser`(name, homeAddress, emailAddress, position, phoneNo, Role_role)
VALUES('Karen', '1 the road', 'k@aren.com', 'slave', '132312', 'Secretary');

INSERT INTO `staffdevelopment`.`siteUser`(name, homeAddress, emailAddress, position, phoneNo, Role_role)
VALUES('Dave', 'The office', 'big@ceo.org.uk', 'Top', '111223', 'CEO');

INSERT INTO `staffdevelopment`.`siteUser`(name, homeAddress, emailAddress, position, phoneNo, Role_role)
VALUES('Clive', 'The office', 'bigger@ceo.org.uk', 'second', '111223', 'CEO');

select * from `staffdevelopment`.`siteUser`;
