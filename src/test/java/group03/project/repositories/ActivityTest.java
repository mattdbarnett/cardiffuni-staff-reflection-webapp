package group03.project.repositories;

import group03.project.domain.Activity;
import group03.project.domain.Objective;
import group03.project.domain.Tag;
import group03.project.services.offered.ActivityService;
import group03.project.services.offered.ObjectiveService;
import group03.project.services.offered.TagService;
import group03.project.services.required.ActivityRepository;
import group03.project.services.required.ObjectiveRepository;
import group03.project.services.required.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase
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

        Activity firstActivity = new Activity("activityTest", "an activity test");
        firstActivity.setIsOfficial(true);

        activityService.save(firstActivity);

        Objective newObj = new Objective(activityService.findByName("activityTest").get(), tagService.findByTagID(1L).get());
        objectiveRepository.save(newObj);

        Long activityInObjective = objectiveRepository.findByActivity_activityID(
                activityService.findByName("activityTest")
                        .get()
                        .getActivityID())
                        .get()
                        .getActivity().getActivityID();

        Activity savedActivity = activityService.findByActivityID(newObj.getActivity().getActivityID()).get();

        assertEquals("an activity test", savedActivity.getDescription());
    }

    @Test
    @WithMockUser(username = "user", password = "pass", roles = "USER")
    public void shouldAddCustomThoughtToActivity() throws Exception {

        Activity customActivity = new Activity("activityTest", "an activity test");


        activityService.save(customActivity);

        Activity savedActivity = activityService.findByName("activityTest").get();


        Objective newObj = new Objective(savedActivity, tagService.findByTagName("Motivational").get());

        objectiveRepository.save(newObj);

        Long activityInObjective = objectiveRepository.findByActivity_activityID(
                activityService.findByName("activityTest")
                        .get() // Sources Activity Object
                        .getActivityID())// sources Activity ID from within object
                        .get() // Collects Objective object from result
                        .getActivity() // Sources Activity object within result
                        .getActivityID(); // Sources Activity id within object.

        Long tagInObjective = objectiveRepository.findByTag_tagID(
                tagService.findByTagName("Motivational")
                        .get() // Sources Tag Object
                        .getTagID())// sources Tag ID from within object
                .get() // Collects Objective object from result
                .getTag() // Sources Tag object within result
                .getTagID(); // Sources Tag id within object.

        Activity finalActivity = activityService.findByActivityID(activityInObjective).get();

        assertEquals("activityTest", activityService.findByActivityID(activityInObjective).get().getName());

        assertEquals("Motivational", tagService.findByTagID(tagInObjective).get().getTagName());

    }

}
