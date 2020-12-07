package group03.project.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String navigateToLogin() {
        return "login";
    }


//
//    @GetMapping("/admin")
//    public String navigateToAdminDashboard() {
//        return "dashboard";
//    }
//
//    @GetMapping("/user")
//    public String navigateToUserDashboard() {
//        return "dashboard";
//    }

    /**
     * Ronan implementation of adding about page - moved to controller controlling home.
     * @return about.html template page.
     */
    @GetMapping("/about")
    public String NavigateToAbout(){
        return "about";
    }

    @GetMapping("/dashboard")
    public String navigateToDashboard(Authentication authentication) {
        System.out.println("am i here?");
        return "dashboard";

//        if (authentication.getAuthorities().contains("ADMIN")) {
//            return "dashboard_a";
//        } else {
//            return "dashboard";
//        }

    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
