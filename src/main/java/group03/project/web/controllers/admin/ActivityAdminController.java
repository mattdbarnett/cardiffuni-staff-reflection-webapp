package group03.project.web.controllers.admin;

import group03.project.domain.*;
import group03.project.services.implementation.ParticipationServiceImpl;
import group03.project.services.implementation.ReflectionServiceImpl;
import group03.project.services.offered.ActivityService;
import group03.project.services.offered.ObjectiveService;
import group03.project.services.offered.TagService;
import group03.project.web.forms.ActivityCreationForm;
import group03.project.web.lists.ReflectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class ActivityAdminController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ObjectiveService objService;

    @Autowired
    private ParticipationServiceImpl participationService;

    @Autowired
    private ReflectionServiceImpl reflectionServiceImpl;

    //Page for adding an official activity as an administrator
    @GetMapping("/add-official-activity")
    public String addOfficialActivity(Model model) {
        ActivityCreationForm activity = new ActivityCreationForm();
        List<Tag> allTags = tagService.findTagsIfOfficial();
        List<Tag> allThoughts = tagService.findTagsIfCustom();
        model.addAttribute("activity", activity);
        model.addAttribute("tags", allTags);
        model.addAttribute("thoughts", allThoughts);
        return "add-oactivity";
    }
    //Submit the activity to the database
    @PostMapping("/add-official-activity")
    public String submitOfficialActivity(@ModelAttribute("activity") @Valid ActivityCreationForm activity,
                                         BindingResult result) {

        activity.allOfficialTags();



            Activity latestActivity = createActivity(activity, result);

            String[] customTags = activity.getCustomTags().split(",");



            for (Map.Entry<String, Boolean> tag : activity.allOfficialTags().entrySet()) {
                if (tag.getValue()) {
                    Tag theTag = tagService.findATagByName(tag.getKey()).get();
                    Objective newObj = new Objective(latestActivity, theTag);
                    objService.createObjective(newObj);

                }
             }
            if (customTags.length > 0) {
                for (String customTag : customTags) {
                    Tag theTag = tagService.findATagByID(Long.valueOf(customTag)).get();
                    Objective newObj = new Objective(latestActivity, theTag);
                    objService.createObjective(newObj);

                }
            }
        return "dashboard_a";
    }


    //Lists all reflections
    @GetMapping("/all-public-reflections")
    public String listParticipations(Model model) {

        List<Reflection> reflections = reflectionServiceImpl.findAllReflections();

        List<Participation> participations = participationService.findAllParticipations();

        //Return all reflections with activity and participation data in a user friendly format
        List<ReflectList> reflectLists = new ArrayList<>();
        for (int x = 0; x < reflections.size(); x++) {

            Reflection currentReflection = reflections.get(x);
            Participation currentParticipation = new Participation();

            if(currentReflection.getIsPublic()) {

                for (int z = 0; z < participations.size(); z++) {
                    Participation participation = participations.get(z);
                    if (currentReflection.getParticipationID() == participation.getParticipationID()) {
                        currentParticipation = participation;
                    }
                }
                Activity currentActivity = participationService.getRelatedActivity(currentParticipation);

                String privacy;
                if (currentReflection.getIsPublic()) {
                    privacy = "Public";
                } else {
                    privacy = "Private";
                }

                String rating;
                if(currentReflection.getRating() == null){
                    rating = "No Rating";
                } else{
                    rating = currentReflection.getRating().toString();
                }
                ReflectList currentReflectList = new ReflectList(
                        currentActivity.getName(),
                        currentParticipation.getDate(),
                        currentActivity.getIsOfficial(),
                        currentReflection.getReflect_what(),
                        currentReflection.getReflect_prompt(),
                        currentReflection.getReflect_happen(),
                        currentReflection.getReflect_eval(),
                        currentReflection.getReflect_diff(),
                        currentReflection.getReflect_lp(),
                        privacy,
                        rating
                );

                reflectLists.add(currentReflectList);
            }
        }

        model.addAttribute("reflections", reflectLists);
        return "all-reflections-admin";
    }

    private Activity createActivity(ActivityCreationForm activityForm,
                                    BindingResult result) {
        Activity newActivity;

        try {
            newActivity = new Activity(
                    activityForm.getName(),
                    activityForm.getDescription());

            newActivity.setIsOfficial(true);

            activityService.saveActivity(newActivity);

        } catch (Exception ex) {
            return null;
        }
        return newActivity;
//        return activityService.findMostRecentActivity();
    }
}
