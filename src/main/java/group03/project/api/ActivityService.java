package group03.project.api;

import group03.project.domain.Activity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ActivityService {

    private List<Activity> activities = Arrays.asList(
            new Activity(0, 1, null, "Sample Activity Name 1", "Description of an activity I did."),
            new Activity(1, 2, null, "Sample Activity Name 2", "Description of another activity I did."),
            new Activity(2, 1, "C:/file.png", "Sample Activity Name 3", null)
    );

    public List<Activity> getAllActivities() {
        return activities;
    }

}
