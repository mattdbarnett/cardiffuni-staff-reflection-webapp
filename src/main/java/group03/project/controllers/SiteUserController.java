package group03.project.controllers;


import group03.project.service.implementation.RoleService;
import group03.project.service.offered.SiteUserRead;
import group03.project.web.NewUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@SessionAttributes({"add", "edit", "delete"})
@Controller
public class SiteUserController {

    static final Logger controlLog = LoggerFactory.getLogger(SiteUserController.class);

    @Autowired
    private SiteUserRead siteUserService;
    @Autowired
    private RoleService roleService;


    @Autowired
    public SiteUserController(SiteUserRead aUserService, RoleService aRoleService) {
        siteUserService = aUserService;
        roleService = aRoleService;
    }

    @GetMapping("add-user")
    public String serveNewUserForm(Model model) {
        NewUserForm newUserForm = new NewUserForm();
        model.addAttribute("newUserForm", newUserForm);
        model.addAttribute("roles", roleService.findAll());
        return "user-add";

    }



}
