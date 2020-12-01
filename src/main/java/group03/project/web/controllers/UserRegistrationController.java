package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserCreationService;
import group03.project.web.forms.UserCreationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {


    private SiteUserCreationService accountService;

    @Autowired
    public UserRegistrationController(SiteUserCreationService aService) {

        accountService = aService;

    }

    @GetMapping("/registration")
    public String ShowAccountCreationForm(Model model) {
        UserCreationForm newAccountForm = new UserCreationForm();
        model.addAttribute("newUser", newAccountForm);
        return "registration";

    }

    @PostMapping("/register")
    public String createNewUser(@ModelAttribute("newUser") @Valid UserCreationForm accountForm, BindingResult result) {

        SiteUser newUser = new SiteUser();
        if(!result.hasErrors()) {
            newUser = createAccount(accountForm, result);
        }

        accountService.createUser(newUser);

        return "redirect:/";
    }


    private SiteUser createAccount(UserCreationForm accountForm, BindingResult result) {
        SiteUser newUser;

        try {
         newUser = new SiteUser(
                 accountForm.getEmailAddress(),
                 accountForm.getPassword(),
                 accountForm.getName());
        } catch (Exception ex) {
            return null;
        }
        return newUser;
    }

}
