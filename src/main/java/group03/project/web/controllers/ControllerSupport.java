package group03.project.web.controllers;

import group03.project.config.SiteUserPrincipal;
import group03.project.domain.SiteUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class ControllerSupport {

    public static String getAuthenticatedUserName(Authentication authentication) {

        String theUser;
                /*
          Cast authentication request principal into the custom SiteUserPrincipal class, in order to source username
          of SiteUser object logging onto system.
         */
        Object principal = authentication.getPrincipal();

        if (principal instanceof SiteUserPrincipal) {

            theUser = ((SiteUserPrincipal) principal).getUsername();
            /**
             * Test purposes, due to mock user created as class "user" in spring security.
             */
        } else if (principal instanceof User) {
            theUser = ((User) principal).getUsername();
        } else {
            /*
            In event of rogue user accessing system, print user to string.
             */
            System.out.println(principal.toString());

            theUser = principal.toString();
        }
        return theUser;

    }
}
