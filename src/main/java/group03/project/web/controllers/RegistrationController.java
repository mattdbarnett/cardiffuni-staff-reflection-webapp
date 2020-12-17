package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserService;
import group03.project.web.forms.UserCreationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class RegistrationController {


    private SiteUserService accountService;
    private PasswordEncoder encoder;

    @Autowired
    public RegistrationController(SiteUserService aService, PasswordEncoder theEncoder) {
        encoder = theEncoder;
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


        if(!result.hasErrors()) {

            try {


                if (accountForm.getPassword().equals(accountForm.getMatchingPassword())) {

                    SiteUser newUser;

                    newUser = createAccount(accountForm, result);

                    accountService.createAUser(newUser);

                    return "redirect:/";

                } else {
                    return "redirect:register";
                }
                /**
                 * Catches any errors made via JPA addition.
                 */
            } catch (Exception e) {
                System.out.println("That username is taken; please try again");

                return "redirect:register";
            }
        } else {
            System.out.println("Result has errors");

            return "redirect:register";
        }
    }


    private SiteUser createAccount(UserCreationForm accountForm,
                                   BindingResult result) {
        SiteUser newUser;

        try {
         newUser = new SiteUser(
                 accountForm.getEmailAddress(),
                 encoder.encode(accountForm.getPassword()),
                 accountForm.getUserName());
        } catch (Exception ex) {
            return null;
        }
        return newUser;
    }

}
