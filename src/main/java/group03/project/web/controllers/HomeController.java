package group03.project.web.controllers;

import group03.project.config.SiteUserPrincipal;
import group03.project.domain.SiteUser;
import group03.project.web.forms.UserCreationForm;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
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

/**
 * Controller handles basic application navigation (login/logout)
 */
@Controller
public class HomeController {
    /**
     * Default navigation mapping to access localhost:8080
     * @return login form for localhost;
     */
    @GetMapping("/")
    public String navigateToLogin() {
        return "login";
    }

    /**
     * Ronan implementation of adding about page - moved to controller controlling home.
     * @return about.html template page.
     */
    @GetMapping("/about")
    public String NavigateToAbout(){
        return "about";
    }

    @GetMapping("/dashboard")
    public String navigateToDashboard(@ModelAttribute("user") String user, Model model, Authentication authentication) {
        System.out.println("Got to dashboard");

        String theUser;

        /**
         * Cast authentication request principal into the custom SiteUserPrincipal class, in order to source username
         * of SiteUser object logging onto system.
         */
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            System.out.println("is user details!!!");
            theUser = ((SiteUserPrincipal)principal).getUsername();
        } else {
            System.out.println("is string...");
            theUser = principal.toString();
        }
//        SiteUserPrincipal principal = (SiteUserPrincipal) authentication.getPrincipal();

        /**
         * Object parsed onto page as attribute for Thymeleaf
         */
        model.addAttribute("user", theUser);

        /**
         * Redirects user object based upon authority set, streaming into 2 different dashboard pages.
         */
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "dashboard_a";
        } else {
            return "dashboard";
        }

    }

    /**
     * Handles method for logging out of application.
     * @param request - object that handles a method to read html body ( getInputStream() );
     * @param response - handles response headers.
     * @return redirection to localhost:8080 page
     */
    @GetMapping("/logout")
    public String HandleLogout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logging out...");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());

        new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "redirect:";
    }

    /**
     * Mapping for failed logins dictated by SecurityConfig class route.
     * @return redirection back to application root.
     */
    @PostMapping("/failed-login")
    public String handleFailedLogin() {
        System.out.println("User failed to login");
        /**
         * returns user back to initial localhost:8080
         */
        return "redirect:";
    }
}
