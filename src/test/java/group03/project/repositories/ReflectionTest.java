package group03.project.repositories;

import group03.project.domain.*;
import group03.project.services.required.ParticipationRepository;
import group03.project.services.required.ReflectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

        Reflection testReflection = new Reflection(null, testParticipation.getParticipationID(), 1, reflect_what, "Test", "Test", "Test", "Test", "Test", false);

        reflectionRepository.save(testReflection);

        Optional<Reflection> findTest = reflectionRepository.findById(testParticipation.getParticipationID());

        assertEquals(reflect_what, findTest.get().getReflect_what());
    }

    @Test
    @WithMockUser(username="admin", password="pass", roles = "ADMIN")
    public void checkReflectionVisibility() {

        Activity testActivity1 = new Activity(null, "Test Activity 1", "Test Url", "Test Desc", true);
        Activity testActivity2 = new Activity(null, "Test Activity 2", "Test Url", "Test Desc", false);
        Activity testActivity3 = new Activity(null, "Test Activity 3", "Test Url", "Test Desc", true);

        activityRepository.save(testActivity1);
        activityRepository.save(testActivity2);
        activityRepository.save(testActivity3);

        Date date = new Date();

        Participation testParticipation1 = new Participation(null, testActivity1.getActivityID(), date, "Participant",  1 );
        Participation testParticipation2 = new Participation(null, testActivity2.getActivityID(), date, "Participant",  1 );
        Participation testParticipation3 = new Participation(null, testActivity3.getActivityID(), date, "Participant",  1 );

        participationRepository.save(testParticipation1);
        participationRepository.save(testParticipation2);
        participationRepository.save(testParticipation3);

        Reflection testReflection1 = new Reflection(null, testParticipation1.getParticipationID(), 1, "Test", "Test", "Test", "Test", "Test", "Test", false);
        Reflection testReflection2 = new Reflection(null, testParticipation1.getParticipationID(), 1, "Test", "Test", "Test", "Test", "Test", "Test", true);
        Reflection testReflection3 = new Reflection(null, testParticipation1.getParticipationID(), 1, "Test", "Test", "Test", "Test", "Test", "Test", true);

        reflectionRepository.save(testReflection1);
        reflectionRepository.save(testReflection2);
        reflectionRepository.save(testReflection3);

        List<Reflection> reflections =  reflectionRepository.findAll();
        List<Reflection> publicReflections = new ArrayList<>();
        for(int i = 0; i < reflections.size(); i++) {
            Reflection currentReflection = reflections.get(i);
            if(currentReflection.getIsPublic() == true) {
                publicReflections.add(currentReflection);
            }
        }

        assertEquals(2, publicReflections.size());

    }
}
