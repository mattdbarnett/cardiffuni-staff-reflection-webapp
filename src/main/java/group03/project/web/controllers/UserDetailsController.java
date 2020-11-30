package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserUpdateService;
import group03.project.services.required.SiteUserAuditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.MissingResourceException;
import java.util.Optional;

@Controller
public class UserDetailsController {

    private SiteUserUpdateService userUpdateService;
    private SiteUserAuditor userAuditor;

    @Autowired
    public UserDetailsController(SiteUserUpdateService anUpdateService, SiteUserAuditor theAuditor) {
        userUpdateService = anUpdateService;
        userAuditor = theAuditor;
    }

    @GetMapping("account/{id}")
    public String userAccountDetails(@PathVariable("id") Long id, Model model) {

        Optional<SiteUser> aSiteUser = userAuditor.findUserById(id);
        if (aSiteUser.isPresent()) {
            model.addAttribute("siteuser", aSiteUser.get());
            return "my-account";
        } else {
            return "redirect:/";
        }
    }
}
