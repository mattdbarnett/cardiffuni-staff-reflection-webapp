package group03.project.service;

import group03.project.domain.Activity;
import group03.project.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService implements ActivityRead {

    @Autowired
    private ActivityRepository activityRepo;

    //Returns a list of all activities in the database
    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();
        activityRepo.findAll().forEach(activities::add);
        return activities;
    }

    //Adds an activity
    public void save(Activity activity) {
        activityRepo.save(activity);
    }

    //Returns the number of activities in the database
    public int getActivityListSize() {
        List<Activity> activities = new ArrayList<>();
        activityRepo.findAll().forEach(activities::add);
        return activities.size();
    }

    @Override
    public List<Activity> findall() {
        return activityRepo.findAll();
    }
}
