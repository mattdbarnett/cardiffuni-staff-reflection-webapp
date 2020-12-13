package group03.project.repositories;

import group03.project.domain.Activity;
import group03.project.domain.Objective;
import group03.project.services.offered.ActivityService;
import group03.project.services.offered.ObjectiveService;
import group03.project.services.offered.TagService;
import group03.project.services.required.ActivityRepository;
import group03.project.services.required.ObjectiveRepository;
import group03.project.services.required.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ActivityTest {

    @Autowired
    public ActivityRepository activityService;
    @Autowired
    public TagRepository tagService;
    @Autowired
    public ObjectiveRepository objectiveRepository;



    @Test
    @WithMockUser(username = "user", password = "pass", roles = "admin")
    public void shouldHaveObjectiveBeLinkedToActivity() throws Exception {

        Activity firstActivity = new Activity("test", "an activity test");

        activityService.save(firstActivity);
        System.out.println(activityService.findByActivityID(1L));



        Objective newObj = new Objective(activityService.findByActivityID(1L).get(), tagService.findByTagID(1L).get());
        objectiveRepository.save(newObj);


        Long activityInObjective = objectiveRepository.findByActivity_activityID(
                activityService.findByActivityID(1L)
                        .get()
                        .getActivityID())
                        .get()
                        .getActivity().getActivityID();

        Activity sourcedActivity = activityService.findByActivityID(newObj.getActivity().getActivityID()).get();

        assertEquals("an activity test", sourcedActivity.getDescription());

    }
}
