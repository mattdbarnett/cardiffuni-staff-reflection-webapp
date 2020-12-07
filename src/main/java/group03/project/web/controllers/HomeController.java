package group03.project.web.controllers;

import group03.project.config.SiteUserPrincipal;
import group03.project.domain.SiteUser;
import group03.project.web.forms.UserCreationForm;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String navigateToLogin() {
        return "login";
    }

//    @GetMapping("/dashboard")
//    public String navigateToDashboard() {
//
//        return "login";
//    }


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
    public String navigateToDashboard(@ModelAttribute("user") SiteUserPrincipal user, Model model, Authentication authentication) {
        System.out.println("Got to dashboard");

        /**
         * Casting principal
         */
        SiteUserPrincipal principal = (SiteUserPrincipal) authentication.getPrincipal();

        model.addAttribute("user", principal);

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "dashboard_a";
        } else {
            return "dashboard";
        }


//        if (authentication.getAuthorities().contains("ADMIN")) {
//            return "dashboard_a";
    }

    @GetMapping("/logout")
    public String HandleLogout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logging out...");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());

        new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "login";
    }

    @PostMapping("/failed-login")
    public String handleFailedLogin() {
        System.out.println("User failed to login");

        return "login";
    }
}
