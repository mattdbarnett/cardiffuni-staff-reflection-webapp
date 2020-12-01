package group03.project.web.controllers;

import group03.project.domain.SiteRole;
import group03.project.domain.SiteUser;
import group03.project.services.implementation.SiteUserService;
import group03.project.services.offered.SiteUserUpdateService;
import group03.project.services.required.SiteUserAuditor;
import group03.project.services.required.SiteUserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class UserDetailsController {

    private SiteUserUpdateService userUpdateService;
    private SiteUserAuditor userAuditor;
    private SiteUserService userService;

    @Autowired
    public UserDetailsController(SiteUserUpdateService anUpdateService, SiteUserAuditor theAuditor, SiteUserService aService) {
        userUpdateService = anUpdateService;
        userAuditor = theAuditor;
        userService = aService;
    }

    @GetMapping("/account/{id}")
    public String userAccountDetails(@PathVariable("id") Long id, Model model) {

        Optional<SiteUser> aSiteUser = userAuditor.findUserById(id);
        System.out.println(aSiteUser);
        if (aSiteUser.isPresent()) {
            SiteUser selectedUser = aSiteUser.get();
            model.addAttribute("siteuser", selectedUser);
            return "my-account";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/all-accounts")
    public String allUsers( Model model) {

        List<SiteUser> users = userService.findAllUsers();

        for (SiteUser user: users) {
            System.out.println(user.getEmailAddress());
        }

        model.addAttribute("users", users);



        return "all-accounts";
//
    }
}
