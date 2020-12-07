package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserService;
import group03.project.services.required.SiteUserAuditor;
import group03.project.web.forms.UserEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class InfoController {

    private SiteUserService userUpdateService;
    private SiteUserAuditor userAuditor;
//    private SiteUserService userService;
    String adminField = "/";
    String accountUserPage;

    @Autowired
    public InfoController(SiteUserService anUpdateService, SiteUserAuditor theAuditor) {
        userUpdateService = anUpdateService;
        userAuditor = theAuditor;
        accountUserPage = "user";
    }

    @GetMapping("/account/{id}")
    public String userAccountDetails(@PathVariable("id") Long id, Model model) {

        Optional<SiteUser> aSiteUser = userAuditor.findUserById(id);
        if (aSiteUser.isPresent()) {
            UserEditForm editForm = new UserEditForm();

            SiteUser selectedUser = aSiteUser.get();
            model.addAttribute("siteuser", selectedUser);
            model.addAttribute("editForm", editForm);
            return accountUserPage + "-selected-account";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/change-name")
    public String changeAccountName(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                    BindingResult result) {

        if(!result.hasErrors()) {
            SiteUser selectedUser = userAuditor.findUserById(Long.parseLong(nameForm.getId())).get();
            selectedUser.setUserName(nameForm.getEdit());
            userUpdateService.updateUser(selectedUser);
            return "redirect:" + adminField + "account/" + nameForm.getId();
        } else {
            return "redirect:" + adminField + "account/" + nameForm.getId();
        }
    }

    @PostMapping("/change-email")
    public String changeEmailAddress(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                     BindingResult result) {

        if(!result.hasErrors()) {
            try {
                SiteUser selectedUser = userAuditor.findUserById(Long.parseLong(nameForm.getId())).get();
                selectedUser.setEmailAddress(nameForm.getEdit());
                userUpdateService.updateUser(selectedUser);
                return "redirect:" + adminField + "account/" + nameForm.getId();
            } catch (TransactionSystemException  e)  {
                return "redirect:" + adminField + "account/" + nameForm.getId();
            }
        } else {
            return "redirect:" + adminField + "account/" + nameForm.getId();
        }

    }

    @PostMapping("/change-password")
    public String changePassword(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                 BindingResult result) {

        if(!result.hasErrors()) {

            SiteUser selectedUser = userAuditor.findUserById(Long.parseLong(nameForm.getId())).get();
            selectedUser.setPassword(nameForm.getEdit());
            userUpdateService.updateUser(selectedUser);
            System.out.println("Success! account/" + nameForm.getId());
            return "redirect:" + adminField + "account/" + nameForm.getId();
        } else {
            System.out.println("Failure. account/" + nameForm.getId());
            return "redirect:" + adminField + "account/" + nameForm.getId();
        }
    }
}
