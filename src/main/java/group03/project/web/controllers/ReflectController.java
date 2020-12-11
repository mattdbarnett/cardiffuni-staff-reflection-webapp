package group03.project.web.controllers;

import group03.project.domain.Activity;
import group03.project.domain.Participation;
import group03.project.domain.Reflection;
import group03.project.domain.SiteUser;
import group03.project.services.implementation.ActivityService;
import group03.project.services.implementation.ParticipationServiceImpl;
import group03.project.services.implementation.ReflectService;
import group03.project.services.offered.SiteUserService;
import group03.project.web.lists.ReflectList;
import org.hibernate.dialect.CUBRIDDialect;
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
        Activity chosenActivity = new Activity();
        reflection.setParticipationID(null);
        List<Activity> activities = activityService.getAllActivities();
        for (int y = 0; y < activityService.getActivityListSize(); y++) {
            Activity currentActivity = activities.get(y);
            if(currentActivity.getActivityID() == activityID) {
                chosenActivity = currentActivity;
            }
        }

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

    //Return the user's reflections
    @GetMapping("/all-my-reflections")
    public String listMyReflections(Model model, Authentication authentication) {
        List<Reflection> reflections = reflectService.findall();
        List<Reflection> myReflections = new ArrayList<>();
        Integer currentID = getCurrentID(authentication);

        //Get a list of all participations the user can or has reflected on
        List<Participation> participations = participationService.findAllParticipations();
        List<Integer> currentParticipations = new ArrayList<>();
        for (int y = 0; y < participationService.getParticipationListSize(); y++) {
            Participation currentPart = participations.get(y);
            if(currentPart.getUserID() == currentID) {
                currentParticipations.add(currentPart.getParticipationID());
            }
        }

        List<ReflectList> formattedReflections = new ArrayList<>();

        //Make a list of all the participations unique to the current user
        for (int z = 0; z < reflectService.findall().size(); z++) {
            Reflection reflection = reflections.get(z);
            if(currentParticipations.contains(reflection.getParticipationID())) {
                myReflections.add(reflection);
            }
        }


        List<ReflectList> reflectLists = new ArrayList<>();
        for (int x = 0; x < myReflections.size(); x++) {
            Reflection currentReflection = myReflections.get(x);
            Participation currentParticipation = new Participation();
            for (int y = 0; y < currentParticipations.size(); y++) {
                Participation participation = participations.get(y);
                if(currentReflection.getParticipationID() == participation.getParticipationID()) {
                    currentParticipation = participation;
                }
            }
            Activity currentActivity = participationService.getRelatedActivity(currentParticipation);

            ReflectList currentReflectList = new ReflectList(
                    currentActivity.getName(),
                    currentParticipation.getDate(),
                    currentActivity.getIsOfficial(),
                    currentReflection.getReflect_what(),
                    currentReflection.getReflect_prompt(),
                    currentReflection.getReflect_happen(),
                    currentReflection.getReflect_eval(),
                    currentReflection.getReflect_diff(),
                    currentReflection.getReflect_lp()
            );

            reflectLists.add(currentReflectList);
        }
        model.addAttribute("reflections", reflectLists);
        return "all-reflections";
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
