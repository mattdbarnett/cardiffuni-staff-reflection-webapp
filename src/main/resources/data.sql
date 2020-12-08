-- Preset data for database --

INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Lead', 'Leading activity');

-- Dummy data for database --


INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions, isActive)
VALUES('k@aren.com', '$2a$10$YhSaTI2UkEJmGmNzR..pouFZlKAHoQR1uvTyAUv5ffGYHTum.BUHy', 'karen', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions,isActive)
VALUES('big@ceo.org.uk', '$2a$10$Es0Jp14TEF2wGQ3xBb8/g.l9PGwH.yBXKBsy4XBcE7tUfFT9Ou6D.', 'dave', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions,isActive)
VALUES('admin@emailexample.com', '$2a$10$0MPUyNqDfnnqegokguyWwehXGQwfEot8GV5TWB7MDd8ztHHTuL4oG', 'admin', 'ROLE_ADMIN', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions, isActive)
VALUES('user@name', '$2a$10$rnXtXnpvlvTKX8IBR7nBpupJRHGu37TLE5ICBisSH.XY26MN3s7rC', 'user', 'ROLE_USER', 1);


