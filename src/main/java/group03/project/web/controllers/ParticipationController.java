package group03.project.web.controllers;

import group03.project.domain.Activity;
import group03.project.domain.Participation;
import group03.project.services.implementation.ActivityService;
import group03.project.services.implementation.ParticipationService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @Autowired
    private ActivityService activityService;

    //Page for adding a participation entry
    @GetMapping("/add_participation")
    public String addParticipation(Model model, Model activityModel) {
        Participation participation = new Participation();
        List<Activity> activities = activityService.findall();
        model.addAttribute("participation", participation);
        activityModel.addAttribute("activities", activities);
        return "Add_Participation";
    }

    //Submit the entry to the database
    @PostMapping("/add_participation")
    public String submitParticipation(@ModelAttribute("participation") Participation participation) {
        //Will only work with data added!!
        participation.setRoleID("0");
        participation. setUserID(1);
        java.util.Date date = new java.util.Date();
        participation.setDate(date);
        participationService.save(participation);
        return "index";
    }

    @GetMapping("/all_participations")
    public String listParticipations(Model model) {
        List<Participation> participations = participationService.findall();
        model.addAttribute("participations", participations);
        return "all-participations";
    }
}
