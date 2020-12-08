-- Preset data for database --

INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Lead', 'Leading activity');


INSERT INTO tag VALUES ('A1', 'Design and plan learning activities and/or programmes of study', 1);

INSERT INTO tag VALUES('A2', 'Teach and/or support learning.', 1);
INSERT INTO tag VALUES('A3', 'Assess and give feedback to learners.', 1);
INSERT INTO tag VALUES('A4', 'Develop effective learning environments and approaches to student support and guidance.', 1);
INSERT INTO tag VALUES('A5', 'Engage in continuing professional development in subjects/disciples and their pedagogy, incorporating research, scholarship and the evaluation of professional practices.', 1);
INSERT INTO tag VALUES('D3.7', 'Supporting colleagues.', 1);
INSERT INTO tag VALUES('K1', 'The subject material', 1);
INSERT INTO tag VALUES('K2', 'Appropriate methods for reaching learning and assessing in the subject area and at the level of the academic programme.', 1);
INSERT INTO tag VALUES('K3', 'How students learn, both generally and within their subject/disciplinary area(s)', 1);
INSERT INTO tag VALUES('K4', 'The use and value of appropriate learning technologies.', 1);
INSERT INTO tag VALUES('K5', 'Methods for evaluating the effectiveness of teaching.', 1);
INSERT INTO tag VALUES('K6', 'The implications of quality assurance and quality enhancement for academic and professional practice with a particular focus on teaching.', 1);
INSERT INTO tag VALUES('V1', 'Respect individual learners and diverse learning communities.', 1);
INSERT INTO tag VALUES('V2', 'Promote participation in higher education and equality of opportunity for learners.', 1);
INSERT INTO tag VALUES('V3', 'Use evidence-informed approaches and the outcomes from research, scholarship and continuing professional development.', 1);
INSERT INTO tag VALUES('V4', 'Acknowledge the wider context in which higher education operates recognising the implications for professional practice', 1);
-- Dummy data for database --


INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions, isActive)
VALUES('k@aren.com', '$2a$10$YhSaTI2UkEJmGmNzR..pouFZlKAHoQR1uvTyAUv5ffGYHTum.BUHy', 'karen', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions,isActive)
VALUES('big@ceo.org.uk', '$2a$10$Es0Jp14TEF2wGQ3xBb8/g.l9PGwH.yBXKBsy4XBcE7tUfFT9Ou6D.', 'dave', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions,isActive)
VALUES('admin@emailexample.com', '$2a$10$0MPUyNqDfnnqegokguyWwehXGQwfEot8GV5TWB7MDd8ztHHTuL4oG', 'admin', 'ROLE_ADMIN', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions, isActive)
VALUES('user@name', '$2a$10$rnXtXnpvlvTKX8IBR7nBpupJRHGu37TLE5ICBisSH.XY26MN3s7rC', 'user', 'ROLE_USER', 1);


