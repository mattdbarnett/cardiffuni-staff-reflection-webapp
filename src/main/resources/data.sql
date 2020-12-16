-- Preset data for database --
USE developmenttoolkit;

INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Participant', 'participating in activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Review', 'Reviewing activity');
INSERT INTO `developmenttoolkit`.`role` VALUES ( 'Lead', 'Leading activity');


INSERT INTO tag (tagName, description, isOfficial) VALUES ('A1', 'Design and plan learning activities and/or programmes of study', 1);
INSERT INTO tag (tagName, description, isOfficial) VALUES('A2', 'Teach and/or support learning.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('A3', 'Assess and give feedback to learners.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('A4', 'Develop effective learning environments and approaches to student support and guidance.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('A5', 'Engage in continuing professional development in subjects/disciples and their pedagogy, incorporating research, scholarship and the evaluation of professional practices.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('D3.7', 'Supporting colleagues.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('K1', 'The subject material', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('K2', 'Appropriate methods for reaching learning and assessing in the subject area and at the level of the academic programme.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('K3', 'How students learn, both generally and within their subject/disciplinary area(s)', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('K4', 'The use and value of appropriate learning technologies.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('K5', 'Methods for evaluating the effectiveness of teaching.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('K6', 'The implications of quality assurance and quality enhancement for academic and professional practice with a particular focus on teaching.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('V1', 'Respect individual learners and diverse learning communities.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('V2', 'Promote participation in higher education and equality of opportunity for learners.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('V3', 'Use evidence-informed approaches and the outcomes from research, scholarship and continuing professional development.', true);
INSERT INTO tag (tagName, description, isOfficial) VALUES('V4', 'Acknowledge the wider context in which higher education operates recognising the implications for professional practice.', true);

INSERT INTO tag (tagName, description, isOfficial) VALUES('worked well', 'I felt the activity''s content worked well.' , false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Motivational', 'I felt Motivated from participating.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Context', 'I felt this activity gave me more context.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Something new', 'I learnt something new on this activity.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Out of my comfort zone', 'I was out of my comfort zone during activity.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Had a go', 'I actively participated', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Good response', 'I garned a good response from all involved.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Needs more work', 'I feel this activity could use improvement.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Back to the drawing board', 'I feel this activity was a failure and needs a rethink.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Phone a friend', 'I feel I need to speak to a friend after this activity.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Apprehensive', 'I was apprehensive about the Activity contents.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Cautious', 'I was Cautious about the Activity contents.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Confident', 'I was Confident in my knowledge of the Activity contents.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Excited', 'I was Excited about the Activity contents.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Depressed', 'I felt Depressed regarding the Activity contents.', false);
INSERT INTO tag (tagName, description, isOfficial) VALUES('Frustrated', 'I was Frustrated with the Activity contents.', false);

-- Dummy data for database --


INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions, isActive)
VALUES('k@aren.com', '$2a$10$YhSaTI2UkEJmGmNzR..pouFZlKAHoQR1uvTyAUv5ffGYHTum.BUHy', 'karen', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`( emailAddress, password, userName, permissions,isActive)
VALUES('david112@outlook.com', '$2a$10$Es0Jp14TEF2wGQ3xBb8/g.l9PGwH.yBXKBsy4XBcE7tUfFT9Ou6D.', 'david112', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions,isActive)
VALUES('admin@emailexample.com', '$2a$10$0MPUyNqDfnnqegokguyWwehXGQwfEot8GV5TWB7MDd8ztHHTuL4oG', 'admin', 'ROLE_ADMIN', 1);

INSERT INTO `developmenttoolkit`.`siteUser`(emailAddress, password, userName, permissions, isActive)
VALUES('user@name', '$2a$10$rnXtXnpvlvTKX8IBR7nBpupJRHGu37TLE5ICBisSH.XY26MN3s7rC', 'user', 'ROLE_USER', 1);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Student Document Reflection Webinar', 'A short webinar regarding how to reflect on student submissions', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (1, 3);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Peer review workshop', 'A group workshop where you can meet up with fellow lecturers and learn how to provide difficult constructive criticism', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (2, 2);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (2, 6);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('The Basics of Biology learning', 'An online group introduction to the process of instructing students on the basics of a Biology degree', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (3, 7);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (3, 8);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (3, 10);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Student Representative course feedback', 'A group feedback session between yourself and the assigned student reps', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (4, 3);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (4, 9);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (4, 11);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Is your workspace just bad?', 'Public talk from show speaker "Ryan David" about the dangers of your working environment, along with improvements to make. ', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (5, 2);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (5, 4);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (5, 8);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (5, 10);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Agile Development Best practice', 'PDF download on following best practice on participating in an Agile project', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (6, 15);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (6, 16);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Fostering a better online classroom', 'Zoom meeting on how to make best of the tools available for assisting students during remote learning', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (7, 4);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (7, 10);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (7, 11);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Student - Master meet-up', 'Self-organised meeting where you c', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (8, 15);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (8, 16);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Agile Development Best practice', 'PDF download on following best practice on participating in an Agile project', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (9, 15);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (9, 16);

INSERT INTO `developmenttoolkit`.`activity` (name, description, isOfficial) VALUES ('Agile Development Best practice', 'PDF download on following best practice on participating in an Agile project', true);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (10, 15);
INSERT INTO `developmenttoolkit`.`objective` (Activity_activityID, Tag_tagID) VALUES (10, 16);