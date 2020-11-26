package group03.project.web;

import group03.project.service.ActivityService;
import group03.project.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityRestController {

    @Autowired
    private ActivityService activityService;

    //Lists all activities in the database
    @RequestMapping("/activities") //Return all activities
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }
}
