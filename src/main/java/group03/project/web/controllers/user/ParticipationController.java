package group03.project.web.controllers.user;

import group03.project.domain.Participation;
import group03.project.domain.Reflection;
import group03.project.domain.SiteUser;
import group03.project.services.implementation.ActivityServiceImpl;
import group03.project.services.implementation.ParticipationServiceImpl;
import group03.project.services.offered.SiteUserService;
import group03.project.web.controllers.ControllerSupport;
import group03.project.web.forms.ActivityJoinForm;
import group03.project.web.forms.ReflectionButtonForm;
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
public class ParticipationController {

    @Autowired
    private ParticipationServiceImpl participationService;

    @Autowired
    private ActivityServiceImpl activityService;

    @Autowired
    private SiteUserService siteUserService;

    //Lists all participations
    @GetMapping("/all-participations")
    public String listParticipations(Model model) {
        List<Participation> participations = participationService.findAllParticipations();
        model.addAttribute("participations", participations);
        return "all-participations";
    }

    //Return the user's participations
    @GetMapping("/all-my-participations")
    public String listMyParticipations(Model model, Authentication authentication) {
        List<Participation> participations = participationService.findAllParticipations();
        List<Participation> myParticipations = new ArrayList<>();
        Long currentID = getCurrentID(authentication);

        //Make a list of all the participations unique to the current user
        for (int z = 0; z < participationService.getParticipationListSize(); z++) {
            Participation participation = participations.get(z);
            if(participation.getUserID() == currentID) {
                myParticipations.add(participation);
            }
        }

        System.out.println(participations);

        System.out.println(myParticipations);
        model.addAttribute("participations", myParticipations);
        return "all-participations";
    }

    @PostMapping("/all-my-participations")
    public String addReflectionButton(@ModelAttribute("participation") @Valid ReflectionButtonForm editForm, Model model) {
        Reflection reflection = new Reflection();
        reflection.setParticipationID(Long.parseLong(editForm.getParticipationReflectID()));
        model.addAttribute("reflection", reflection);
        return "add-reflection-button";
    }

    //Get the current user's ID
    Long getCurrentID(Authentication authentication) {
        String currentUserName = ControllerSupport.getAuthenticatedUserName(authentication);
        Optional<SiteUser> currentUserOptional = siteUserService.findUserByUserName(currentUserName);
        SiteUser currentUser = currentUserOptional.get();
        Long currentUserID = currentUser.getUserID();

        return currentUserID;
    }
}
