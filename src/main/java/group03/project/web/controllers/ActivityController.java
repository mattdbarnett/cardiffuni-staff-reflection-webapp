package group03.project.web.controllers;

import group03.project.domain.Participation;
import group03.project.domain.SiteUser;
import group03.project.services.implementation.ActivityService;
import group03.project.domain.Activity;
import group03.project.services.implementation.ParticipationServiceImpl;
import group03.project.services.offered.SiteUserService;
import group03.project.web.forms.ActivityJoinForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ParticipationServiceImpl participationService;

    @Autowired
    private SiteUserService siteUserService;

    //Page for adding an official activity as an administrator
    @GetMapping("/add-official-activity")
    public String addOfficialActivity(Model model) {
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        return "add-oactivity";
    }
    //Submit the activity to the database
    @PostMapping("/add-official-activity")
    public String submitOfficialActivity(@ModelAttribute("activity") Activity activity) {
        activity.setIsOfficial(true);
        activityService.save(activity);
        return "redirect:";
    }
    //Page for adding a custom activity as a user
    @GetMapping("/add-custom-activity")
    public String addCustomActivity(Model model) {
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        return "add-cactivity";
    }
    //Submit the activity to the database
    @PostMapping("/add-custom-activity")
    public String submitCustomActivity(@ModelAttribute("activity") Activity activity, Authentication authentication) {
        String inputName = activity.getName();
        activity.setName("[Custom] " + inputName);
        activity.setIsOfficial(false);
        activityService.save(activity);
        java.util.Date date = new java.util.Date();
        Integer currentUserID = getCurrentID(authentication);
        Participation participation = new Participation(null, activity.getActivityID(), date, "Participant", currentUserID );
        participationService.createParticipation(participation);
        return "dashboard";
    }
    //List all activities the user can add themselves too
    @GetMapping("/activities-signup-list")
    public String listActivities(Model model, Authentication authentication) {
        List<Activity> activities = activityService.findall();
        List<Participation> participations = participationService.findAllParticipations();
        Integer currentID = getCurrentID(authentication);
        //Get a list of all activities the user is currently participating in
        List<Integer> currentActivitiesIDs = new ArrayList<>();
        for (int y = 0; y < participationService.getParticipationListSize(); y++) {
            Participation currentPart = participations.get(y);
            if(currentPart.getUserID() == currentID) {
                currentActivitiesIDs.add(currentPart.getActivityID());
            }
        }
        //Make sure the user can only sign up for official activities they are not already doing
        List<Activity> officialActivities = new ArrayList<>();
        for (int x = 0; x < activityService.getActivityListSize(); x++) {
            Activity currentActivity = activities.get(x);
            if(currentActivity.getIsOfficial() == true) {
                if(currentActivitiesIDs.contains(currentActivity.getActivityID()) == false) {
                    officialActivities.add(currentActivity);
                }
            }
        }
        ActivityJoinForm editForm = new ActivityJoinForm();
        model.addAttribute("editForm", editForm);
        model.addAttribute("activities", officialActivities);
        return "all-activities";
    }
    //Add a participation for the official activity the user has just signed up to
    @PostMapping("/activities-signup-list")
    public String joinActivity(@ModelAttribute("activity") @Valid ActivityJoinForm editForm, Authentication authentication) {
        java.util.Date date = new java.util.Date();
        Integer currentUserID = getCurrentID(authentication);
        Participation participation = new Participation(null,  Integer.parseInt(editForm.getActivityJoinID()),date, "Participant", currentUserID);
        participationService.createParticipation(participation);
        return "dashboard";
    }
    //Get the current user's ID
    Integer getCurrentID(Authentication authentication) {
        String currentUserName = ControllerSupport.getAuthenticatedUserName(authentication);
        Optional<SiteUser> currentUserOptional = siteUserService.findUserByUserName(currentUserName);
        SiteUser currentUser = currentUserOptional.get();
        Long currentUserID = currentUser.getUserID();
        Integer currentUserIDInt = currentUserID.intValue();
        return currentUserIDInt;
    }

}
