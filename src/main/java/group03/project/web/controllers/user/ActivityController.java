package group03.project.web.controllers.user;

import group03.project.domain.Participation;
import group03.project.domain.SiteUser;
import group03.project.domain.Tag;
import group03.project.domain.Activity;
import group03.project.services.offered.ActivityService;
import group03.project.services.offered.ParticipationService;
import group03.project.services.offered.SiteUserService;
import group03.project.services.offered.TagService;
import group03.project.web.controllers.ControllerSupport;
import group03.project.web.forms.ActivityJoinForm;
import group03.project.web.forms.ActivityCreationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class ActivityController {

    private ActivityService activityService;
    private ParticipationService participationService;
    private SiteUserService siteUserService;
    private TagService tagService;

    @Autowired
    public ActivityController(ActivityService actService, ParticipationService partService,
                              SiteUserService userService, TagService theTagService) {
        activityService = actService;
        participationService = partService;
        siteUserService = userService;
        tagService = theTagService;
    }





    //Page for adding a custom activity as a user
    @GetMapping("/add-custom-activity")
    public String addCustomActivity(Model model) {
        ActivityCreationForm activity = new ActivityCreationForm();
//        Activity activity = new Activity();
        List<Tag> allTags = tagService.findTagsIfCustom();
        model.addAttribute("activity", activity);
        model.addAttribute("tags", allTags);
        return "add-cactivity";
    }
    //Submit the activity to the database
    @PostMapping("/add-custom-activity")
    public String submitCustomActivity(RedirectAttributes redirectAttributes, @ModelAttribute("activity") Activity activity, Authentication authentication) {
        String inputName = activity.getName();
        activity.setName("[Custom] " + inputName);
        activity.setIsOfficial(false);
        activityService.saveActivity(activity);
        java.util.Date date = new java.util.Date();
        Long currentUserID = getCurrentID(authentication);
        Participation participation = new Participation(null, activity.getActivityID(), date, "Participant", currentUserID );
        participationService.createParticipation(participation);
        redirectAttributes.addFlashAttribute("success",true);
        redirectAttributes.addFlashAttribute("type","cactivity");
        return "redirect:/dashboard";
    }
    //List all activities the user can add themselves too
    @GetMapping("/activities-signup-list")
    public String listActivities(Model model, Authentication authentication) {
        List<Activity> activities = activityService.findAllActivities();
        List<Participation> participations = participationService.findAllParticipations();
        Long currentID = getCurrentID(authentication);
        //Get a list of all activities the user is currently participating in
        List<Long> currentActivitiesIDs = new ArrayList<>();
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
        Long currentUserID = getCurrentID(authentication);
        Participation participation = new Participation(null,  Long.parseLong(editForm.getActivityJoinID()),date, "Participant", currentUserID);
        participationService.createParticipation(participation);
        return "dashboard";
    }
    //Get the current user's ID
    Long getCurrentID(Authentication authentication) {
        String currentUserName = ControllerSupport.getAuthenticatedUserName(authentication);
        Optional<SiteUser> currentUserOptional = siteUserService.findUserByUserName(currentUserName);
        SiteUser currentUser = currentUserOptional.get();
        Long currentUserID = currentUser.getUserID();
//        Integer currentUserIDInt = currentUserID.intValue();
        return currentUserID;
    }

}
