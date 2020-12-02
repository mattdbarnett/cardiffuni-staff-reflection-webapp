package group03.project.web.controllers;

import group03.project.services.offered.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class TagAdminController extends TagController{
    /**
     * Links up the tag method interface into controller for accessing database changes.
     *
     * @param aService
     */
    public TagAdminController(TagService aService) {
        super(aService);

        adminAttribute = "/admin/";

        pageChoice = "-admin";

        System.out.println("test: page choice = " + pageChoice);
    }
}
