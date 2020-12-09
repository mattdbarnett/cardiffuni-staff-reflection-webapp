package group03.project.repositories;

import group03.project.domain.Activity;
import group03.project.domain.Participation;
import group03.project.services.implementation.ActivityService;
import group03.project.services.implementation.ParticipationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
@ContextConfiguration
public class ParticipationTest {

    @Autowired
    ParticipationRepository participationRepository;

    @Autowired
    ParticipationService participationService;

    @Autowired
    ActivityService activityService;

    @Test
    @WithMockUser(username="admin", password="pass", roles = "ADMIN")
    public void addParticipationForOActivity() {
        Activity testActivity = new Activity(null, "Test Activity", "Test Url", "Test Desc", true);
        java.util.Date date = new java.util.Date();

        Participation testParticipation = new Participation(null, date, testActivity.getActivityID(), 1, "USER");

        Optional<Participation> findTest = participationRepository.findById(testParticipation.getParticipationID());

        assertEquals(date, findTest.get().getDate());
    }

    @Test
    @WithMockUser(username="admin", password="pass", roles = "ADMIN")
    public void generateParticipationID() {
        Activity testActivity = new Activity(null, "Test Activity", "Test Url", "Test Desc", true);
        java.util.Date date = new java.util.Date();

        Participation testParticipation = new Participation(null, date, testActivity.getActivityID(), 1, "USER");

        Optional<Participation> findTest = participationRepository.findById(testParticipation.getParticipationID());

        assertNotEquals(null, findTest.get().getParticipationID());
    }
}
