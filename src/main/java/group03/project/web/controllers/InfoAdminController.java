package group03.project.web.controllers;

import group03.project.domain.SiteUser;
import group03.project.services.implementation.SiteUserServiceImpl;
import group03.project.services.offered.SiteUserService;
import group03.project.web.forms.UserEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class InfoAdminController {

//    private final SiteUserUpdateService userUpdateService;
//    private final SiteUserAuditor userAuditor;
private final SiteUserService userUpdateService;
    private final PasswordEncoder encoder;

    @Autowired
    public InfoAdminController(SiteUserService aService, PasswordEncoder theEncoder) {
        encoder = theEncoder;
        userUpdateService = aService;

    }

    @GetMapping("all-accounts")
    public String allUsers( Model model) {

        List<SiteUser> users = userUpdateService.findAllUsers();

        model.addAttribute("users", users);



        return "all-accounts";
//
    }

    @GetMapping("/account/{userName}")
    public String AdminAccountDetails(@PathVariable("userName") String username, Model model) {

//        String name = ControllerSupport.getAuthenticatedUserName(authentication);

        Optional<SiteUser> aSiteUser = userUpdateService.findUserByUserName(username);
        if (aSiteUser.isPresent()) {
            UserEditForm editForm = new UserEditForm();

            SiteUser selectedUser = aSiteUser.get();
            model.addAttribute("siteuser", selectedUser);
            model.addAttribute("editForm", editForm);
            return "admin-selected-account";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/change-name")
    public String changeAccountName(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                    BindingResult result) {

        if(!result.hasErrors()) {
            SiteUser selectedUser = userUpdateService.findUserById(Long.parseLong(nameForm.getId())).get();
            selectedUser.setUserName(nameForm.getEdit());
            userUpdateService.updateUser(selectedUser);
            return "redirect:/admin/account/" + selectedUser.getUserName();
        } else {
            return "all-accounts";
        }
    }

    @PostMapping("/change-email")
    public String changeEmailAddress(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                     BindingResult result) {


        if(!result.hasErrors()) {
            try {
                SiteUser selectedUser = userUpdateService.findUserById(Long.parseLong(nameForm.getId())).get();
                selectedUser.setEmailAddress(nameForm.getEdit());
                userUpdateService.updateUser(selectedUser);
                return "redirect:/admin/account/" + selectedUser.getUserName();

                /*
                Catches any email additions with are incorrectly formatted
                 */
            } catch (TransactionSystemException e)  {
                return "all-accounts";
            }
        } else {
            return "all-accounts";
        }

    }

    @PostMapping("/reset-password")
    public String changePassword(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                 BindingResult result) {

        if(!result.hasErrors()) {

            SiteUser selectedUser = userUpdateService.findUserById(Long.parseLong(nameForm.getId())).get();
            selectedUser.setPassword(encoder.encode("p"));
            userUpdateService.updateUser(selectedUser);

            return "redirect:/admin/account/" + selectedUser.getUserName();
         } else {
            return "all-accounts";
        }

    }
}
