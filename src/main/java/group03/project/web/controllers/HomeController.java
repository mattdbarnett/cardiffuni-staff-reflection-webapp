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
    public String navigateToRootPage() {
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

        String theUser = ControllerSupport.getAuthenticatedUserName(authentication);
       /*
          String parsed onto page as attribute for Thymeleaf
         */
        model.addAttribute("user", theUser);

                /*
          Redirects user object based upon authority set, streaming into 2 different dashboard pages.
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
        /*
          Collects current authentication found in session.
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        /*
          Performs static logout method that expires all parsed session attributes.
         */
        new SecurityContextLogoutHandler().logout(request, response, authentication);
        /*
          Redirect user back to initial localhost:8080.
         */
        return "redirect:";
    }

    /**
     * Mapping for failed logins dictated by SecurityConfig class route.
     * @return redirection back to application root.
     */
    @PostMapping("/failed-login")
    public String handleFailedLogin(HttpServletRequest request) {

//        if(request.getHeader("referer") != null) {
            return "redirect:" + request.getHeader("referer");
//        }
//        /**
//         * returns user back to initial localhost:8080
//         */
//
//        return "redirect:";
    }
}
