package group03.project.web.controllers;

import group03.project.domain.Activity;
import group03.project.domain.Participation;
import group03.project.domain.Reflection;
import group03.project.domain.SiteUser;
import group03.project.services.implementation.ActivityService;
import group03.project.services.implementation.ParticipationServiceImpl;
import group03.project.services.implementation.ReflectService;
import group03.project.services.offered.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class ReflectController {

    @Autowired
    private ParticipationServiceImpl participationService;

    @Autowired
    private ReflectService reflectService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SiteUserService siteUserService;

    //Add a reflection
    @GetMapping("/add-reflection")
    public String addReflection(Model model, Authentication authentication) {
        Reflection reflection = new Reflection();
        model.addAttribute("reflection", reflection);

        List<Activity> activities = activityService.findall();
        List<Participation> participations = participationService.findAllParticipations();
        Integer currentID = getCurrentID(authentication);
        //Get a list of all activities the user is currently participating in
        List<Integer> currentActivitiesIDs = new ArrayList<>();
        for (int x = 0; x < participationService.getParticipationListSize(); x++) {
            Participation currentPart = participations.get(x);
            if(currentPart.getUserID() == currentID) {
                currentActivitiesIDs.add(currentPart.getActivityID());
            }
        }
        //Make sure the user can only choose official activities
        List<Activity> possibleActivities = new ArrayList<>();
        for (int x = 0; x < activityService.getActivityListSize(); x++) {
            Activity currentActivity = activities.get(x);
            if(currentActivitiesIDs.contains(currentActivity.getActivityID()) == true) {
                possibleActivities.add(currentActivity);
            }
        }

        model.addAttribute("activities", possibleActivities);
        return "add-reflection";
    }

    //Submit the entry to the database
    @PostMapping("/add-reflection")
    public String submitParticipation(@ModelAttribute("reflection") Reflection reflection, Authentication authentication) {

        Integer activityID = reflection.getParticipationID();
        reflection.setParticipationID(null);
        Integer currentID = getCurrentID(authentication);
        List<Participation> participations = participationService.findAllParticipations();
        Participation chosenParticipation = new Participation();
        for (int x = 0; x < participationService.getParticipationListSize(); x++) {
            Participation currentPart = participations.get(x);
            if(currentPart.getUserID() == currentID) {
                if(currentPart.getActivityID() == activityID) {
                    chosenParticipation = currentPart;
                }
            }
        }

        reflection.setParticipationID(chosenParticipation.getParticipationID());
        reflection.setTagID(1); //Placeholder until we assign tags to activities

        reflectService.save(reflection);
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
