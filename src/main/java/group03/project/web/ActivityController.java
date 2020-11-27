package group03.project.web;

import group03.project.service.ActivityService;
import group03.project.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    //Page for adding an official activity as an administrator
    @GetMapping("/add_official_activity")
    public String addOfficialActivity(Model model) {
        Activity activity = new Activity();
        activity.setUserID(1);
        model.addAttribute("activity", activity);
        return "Add_OActivity";
    }

    //Submit the activity to the database
    @PostMapping("/add_official_activity")
    public String submitOfficialActivity(@ModelAttribute("activity") Activity activity) {
        activity.setActivityID(activityService.getActivityListSize());
        activity.setUserID(1); //No login system yet - placeholder userID
        activityService.save(activity);
        return "Add_OActivity_Success";
    }
}
