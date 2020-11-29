package group03.project.controller;

import group03.project.controller.forms.AccountForm;
import group03.project.domain.SiteUser;
import group03.project.service.implementation.SiteUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    @Autowired
    private SiteUserAccountService userAccountService;

    @GetMapping("/registration")
    public String ShowAccountCreationForm(Model model) {
        AccountForm newAccountForm = new AccountForm();
        model.addAttribute("user", newAccountForm);
        return null;

    }

    @PostMapping("/register")
    public String createNewUser(@ModelAttribute("user") @Valid AccountForm accountForm, BindingResult result) {

        SiteUser newUser = new SiteUser();
        if(!result.hasErrors()) {
            newUser = createAccount(accountForm, result);
        }

        return "login";
    }


    private SiteUser createAccount(AccountForm accountForm, BindingResult result) {
        SiteUser newUser = null;

        try {
         newUser = new SiteUser(accountForm.getEmailAddress(), accountForm.getPassword());
        } catch (Exception ex) {
            return null;
        }
        return newUser;
    }

}
