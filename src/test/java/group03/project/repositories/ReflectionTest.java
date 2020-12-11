package group03.project.repositories;

import group03.project.domain.*;
import group03.project.services.implementation.ActivityService;
import group03.project.services.offered.ParticipationService;
import group03.project.services.required.ParticipationRepository;
import group03.project.services.required.ReflectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
@ContextConfiguration
public class ReflectionTest {

    @Autowired
    ParticipationRepository participationRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    ReflectionRepository reflectionRepository;

    @Test
    @WithMockUser(username="admin", password="pass", roles = "ADMIN")
    public void addReflectionForAParticipation() {

        Activity testActivity = new Activity(null, "Test Activity", "Test Url", "Test Desc", true);

        activityRepository.save(testActivity);

        Date date = new Date();

        Participation testParticipation = new Participation(null, testActivity.getActivityID(), date, "Participant",  1 );

        participationRepository.save(testParticipation);

        String reflect_what = "Test Reflect_What";

        Reflection testReflection = new Reflection(null, testParticipation.getParticipationID(), 1, reflect_what, "Test", "Test", "Test", "Test", "Test");

        reflectionRepository.save(testReflection);

        Optional<Reflection> findTest = reflectionRepository.findById(testParticipation.getParticipationID());

        assertEquals(reflect_what, findTest.get().getReflect_what());
    }
}
