package group03.project.web.controllers;

import group03.project.domain.SiteRole;
import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserUpdateService;
import group03.project.services.required.SiteUserAuditor;
import group03.project.services.required.SiteUserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserDetailsController {

    private SiteUserUpdateService userUpdateService;
    private SiteUserAuditor userAuditor;

    @Autowired
    public UserDetailsController(SiteUserUpdateService anUpdateService, SiteUserAuditor theAuditor) {
        userUpdateService = anUpdateService;
        userAuditor = theAuditor;
    }

    @GetMapping("/account/{id}")
    public String userAccountDetails(@PathVariable("id") Long id, Model model) {

        Optional<SiteUser> aSiteUser = userAuditor.findUserById(id);
        System.out.println(aSiteUser);
        if (aSiteUser.isPresent()) {
            SiteUser selectedUser = aSiteUser.get();
            selectedUser.setName("test");
            model.addAttribute("siteuser", selectedUser);
            return "my-account";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/all-accounts")
    public String allUsers( Model model) {

        Set<SiteUser> users = new HashSet<>(userAuditor.findAllUsers().stream().map();

        model.addAttribute("users", users);

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.toString());

        }

        return "all-accounts";

    }
}
