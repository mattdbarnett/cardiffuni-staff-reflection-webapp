package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserService;
import group03.project.web.forms.UserCreationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {


    private SiteUserService accountService;

    @Autowired
    public UserRegistrationController(SiteUserService aService) {

        accountService = aService;

    }

    @GetMapping("/register")
    public String ShowAccountCreationForm(Model model) {
        UserCreationForm newAccountForm = new UserCreationForm();
        model.addAttribute("newUser", newAccountForm);
        return "registration";

    }

    @PostMapping("/register-user")
    public String createNewUser(@ModelAttribute("newUser") @Valid UserCreationForm accountForm,
                                BindingResult result) {
        System.out.println("navigated to create user");


        if(!result.hasErrors()) {
            System.out.println("result has no errors");

            SiteUser newUser;

            newUser = createAccount(accountForm, result);

            accountService.createAUser(newUser);

            return "login";
        } else {
            System.out.println("Result has errors");

            return "redirect:registration";


        }




    }


    private SiteUser createAccount(UserCreationForm accountForm,
                                   BindingResult result) {
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
