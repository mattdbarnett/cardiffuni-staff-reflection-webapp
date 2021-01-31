package group03.project.repositories;

import group03.project.domain.*;
import group03.project.services.required.ActivityRepository;
import group03.project.services.required.ParticipationRepository;
import group03.project.services.required.ReflectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void checkReflectionVisibility() {

        Activity testActivity1 = new Activity(null, "Test Activity 1", "Test Url", "Test Desc", true);
        Activity testActivity2 = new Activity(null, "Test Activity 2", "Test Url", "Test Desc", false);
        Activity testActivity3 = new Activity(null, "Test Activity 3", "Test Url", "Test Desc", true);

        activityRepository.save(testActivity1);
        activityRepository.save(testActivity2);
        activityRepository.save(testActivity3);

        Date date = new Date();

        Participation testParticipation1 = new Participation(null, testActivity1.getActivityID(), date, "Participant",  1L );
        Participation testParticipation2 = new Participation(null, testActivity2.getActivityID(), date, "Participant",  1L );
        Participation testParticipation3 = new Participation(null, testActivity3.getActivityID(), date, "Participant",  1L );

        participationRepository.save(testParticipation1);
        participationRepository.save(testParticipation2);
        participationRepository.save(testParticipation3);


        Reflection testReflection1 = new Reflection(null, testParticipation1.getParticipationID(), 1L, "Test", "Test", "Test", "Test", "Test", "Test", false, null);
        Reflection testReflection2 = new Reflection(null, testParticipation1.getParticipationID(), 1L, "Test", "Test", "Test", "Test", "Test", "Test", true, null);
        Reflection testReflection3 = new Reflection(null, testParticipation1.getParticipationID(), 1L, "Test", "Test", "Test", "Test", "Test", "Test", true, null);


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

        assertEquals(5, publicReflections.size());
        //Assertion takes into account the 2 public reflections already present within the dummy data.
    }

    @Test
    @WithMockUser(username="admin", password="pass", roles = "ADMIN")
    public void returnReflectionRating() {

        Long rating = 5L;

        Activity testActivity = new Activity(null, "Test Activity", "Test Url", "Test Desc", true);
        activityRepository.save(testActivity);
        Date date = new Date();
        Participation testParticipation = new Participation(null, testActivity.getActivityID(), date, "Participant",  1L );
        participationRepository.save(testParticipation);
        Reflection testReflection = new Reflection(null, testParticipation.getParticipationID(), 1L, "Test", "Test", "Test", "Test", "Test", "Test", true, rating);
        reflectionRepository.save(testReflection);

        Reflection reflection = reflectionRepository.findAll().get(0);

        assertEquals(rating, reflection.getRating());
    }

    @Test
    @WithMockUser(username="user",password="pass",roles="admin")
    public void privacyTest() {

        Activity testActivity = new Activity(null, "Test Activity", "Test Url", "Test Desc", true);
        activityRepository.save(testActivity);
        Date date = new Date();
        Participation testParticipation1 = new Participation(null, testActivity.getActivityID(), date, "Participant",  1L );
        Participation testParticipation2 = new Participation(null, testActivity.getActivityID(), date, "Participant",  2L );
        participationRepository.save(testParticipation1);
        participationRepository.save(testParticipation2);
        Reflection testReflection1 = new Reflection(null, testParticipation1.getParticipationID(), 1L, "Test", "Test", "Test", "Test", "Test", "Test", true, 3L);
        Reflection testReflection2 = new Reflection(null, testParticipation2.getParticipationID(), 1L, "Test", "Test", "Test", "Test", "Test", "Test", false, 3L);
        reflectionRepository.save(testReflection1);
        reflectionRepository.save(testReflection2);

        List<Reflection> publicReflections = new ArrayList<>();

        //When reflections are sorted in the ReflectionController, they undergo exact the following process:
        List<Reflection> reflections = reflectionRepository.findAll();
        for (int x = 0; x < reflections.size(); x++) {
            Reflection currentReflection = reflections.get(x);
            if (currentReflection.getIsPublic()) {
                publicReflections.add(currentReflection);
            }
        }

        //If only the public reflection is added, it asserts that private reflections will not be returned by the controller for anyone else to use otherwise.
        assertEquals(4, publicReflections.size());
        //Assertion takes into account the 2 public reflections already present within the dummy data.
    }
}
