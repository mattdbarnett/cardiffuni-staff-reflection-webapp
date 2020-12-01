package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.implementation.SiteUserService;
import group03.project.services.offered.SiteUserUpdateService;
import group03.project.services.required.SiteUserAuditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class InfoAdminController extends InfoUserController {

    private final SiteUserUpdateService userUpdateService;
    private final SiteUserAuditor userAuditor;
    private final SiteUserService userService;

    @Autowired
    public InfoAdminController(SiteUserUpdateService anUpdateService, SiteUserAuditor theAuditor, SiteUserService aService) {
        super(anUpdateService, theAuditor, aService);

        userUpdateService = anUpdateService;
        userAuditor = theAuditor;
        userService = aService;
        accountUserPage = "selected-account-admin";
        adminField = "/admin/";
    }

    @GetMapping("all-accounts")
    public String allUsers( Model model) {

        List<SiteUser> users = userService.findAllUsers();

        model.addAttribute("users", users);



        return "all-accounts";
//
    }




}
