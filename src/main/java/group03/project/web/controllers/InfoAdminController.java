package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.implementation.SiteUserJPAService;
import group03.project.services.offered.SiteUserService;
import group03.project.services.required.SiteUserAuditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class InfoAdminController extends InfoController {

//    private final SiteUserUpdateService userUpdateService;
//    private final SiteUserAuditor userAuditor;
    private final SiteUserJPAService userService;

    @Autowired
    public InfoAdminController(SiteUserService anUpdateService, SiteUserAuditor theAuditor, SiteUserJPAService aService) {
        super(anUpdateService, theAuditor);

        userService = aService;
//        userUpdateService = anUpdateService;
//        userAuditor = theAuditor;
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
