package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.implementation.SiteUserServiceImpl;
import group03.project.services.offered.SiteUserService;
import group03.project.web.forms.UserEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class InfoAdminController {

//    private final SiteUserUpdateService userUpdateService;
//    private final SiteUserAuditor userAuditor;
private final SiteUserService userUpdateService;
    private final PasswordEncoder encoder;

    @Autowired
    public InfoAdminController(SiteUserService aService, PasswordEncoder theEncoder) {
        encoder = theEncoder;
        userUpdateService = aService;

    }

    @GetMapping("all-accounts")
    public String allUsers( Model model) {

        List<SiteUser> users = userUpdateService.findAllUsers();

        model.addAttribute("users", users);



        return "all-accounts";
//
    }

    @GetMapping("/account/{userName}")
    public String userAccountDetails(@PathVariable("userName") String username, Model model) {

//        String name = ControllerSupport.getAuthenticatedUserName(authentication);

        Optional<SiteUser> aSiteUser = userUpdateService.findUserByUserName(username);
        if (aSiteUser.isPresent()) {
            UserEditForm editForm = new UserEditForm();

            SiteUser selectedUser = aSiteUser.get();
            model.addAttribute("siteuser", selectedUser);
            model.addAttribute("editForm", editForm);
            return "admin-selected-account";
        } else {
            return "redirect:/";
        }
    }
}
