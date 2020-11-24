package group03.project.api;

import group03.project.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/activities") //Return all activities
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

}
