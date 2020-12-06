package group03.project.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String navigateToLogin() {
        return "login";
    }

    @GetMapping("/admin")
    public String navigateToAdminDashboard() {
        return "dashboard";
    }

    @GetMapping("/user")
    public String navigateToUserDashboard() {
        return "dashboard";
    }

    /**
     * Ronan implementation of adding about page - moved to controller controlling home.
     * @return about.html template page.
     */
    @GetMapping("/about")
    public String NavigateToAbout(){
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
