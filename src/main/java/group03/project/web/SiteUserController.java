package group03.project.web;

import group03.project.domain.SiteUser;
import group03.project.component.SiteUserCreator;
import group03.project.service.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class SiteUserController {

    private final SiteUserCreator siteUserCreationEngine;
    private final SiteUserService siteFullUserData;


    @Autowired
    public SiteUserController(SiteUserCreator aSiteUserCreator, SiteUserService theSiteUserData) {
        siteUserCreationEngine =  aSiteUserCreator;
        siteFullUserData = theSiteUserData;
    }

    @ModelAttribute("allUsers")
    public List<SiteUser> allUsers() { return siteFullUserData.findAll(); }


//    private final
}
