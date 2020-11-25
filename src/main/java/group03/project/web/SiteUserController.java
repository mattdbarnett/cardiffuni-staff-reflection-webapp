package group03.project.web;

import group03.project.domain.SiteUser;
import group03.project.domain.SiteUserCreator;
import group03.project.domain.SiteUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class SiteUserController {

    private final SiteUserCreator siteUserCreationEngine;
    private final SiteUserData siteFullUserData;


    @Autowired
    public SiteUserController(SiteUserCreator aSiteUserCreator, SiteUserData theSiteUserData) {
        siteUserCreationEngine =  aSiteUserCreator;
        siteFullUserData = theSiteUserData;
    }

    @ModelAttribute("allUsers")
    public List<SiteUser> allUsers() { return siteFullUserData.findAll(); }


//    private final
}
