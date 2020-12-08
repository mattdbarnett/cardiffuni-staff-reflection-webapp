package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.implementation.SiteUserServiceImpl;
import group03.project.services.offered.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class InfoAdminController extends InfoController {

//    private final SiteUserUpdateService userUpdateService;
//    private final SiteUserAuditor userAuditor;
    private final SiteUserServiceImpl userService;

    @Autowired
    public InfoAdminController(SiteUserService anUpdateService, SiteUserServiceImpl aService, PasswordEncoder encoder) {
        super(anUpdateService, encoder);

        userService = aService;
//        userUpdateService = anUpdateService;
//        userAuditor = theAuditor;
        accountUserPage = "admin";
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
