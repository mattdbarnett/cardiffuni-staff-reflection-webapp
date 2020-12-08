package group03.project.web.controllers;

import group03.project.domain.SiteUser;
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
import java.util.*;

@Controller
@RequestMapping("user")
public class InfoController {

    private final SiteUserService userUpdateService;
    private final PasswordEncoder encoder;

    String adminField = "/";
    String accountUserPage;



    @Autowired
    public InfoController(group03.project.services.offered.SiteUserService anUpdateService,
                          PasswordEncoder theEncoder) {
        userUpdateService = anUpdateService;
        accountUserPage = "user";
        encoder = theEncoder;

    }

    @GetMapping("/account")
    public String userAccountDetails( Model model, Authentication authentication) {

        String name = ControllerSupport.getAuthenticatedUserName(authentication);

        Optional<SiteUser> aSiteUser = userUpdateService.findUserByUserName(name);
        if (aSiteUser.isPresent()) {
            UserEditForm editForm = new UserEditForm();

            SiteUser selectedUser = aSiteUser.get();
            model.addAttribute("siteuser", selectedUser);
            model.addAttribute("editForm", editForm);
            return "user-selected-account";
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
        }
        return "redirect:/logout";
    }

    @PostMapping("/change-email")
    public String changeEmailAddress(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                     BindingResult result) {

        System.out.println("test1");

        if(!result.hasErrors()) {
            try {
                System.out.println("test2");
                SiteUser selectedUser = userUpdateService.findUserById(Long.parseLong(nameForm.getId())).get();
                System.out.println("test3");
                selectedUser.setEmailAddress(nameForm.getEdit());
                System.out.println("test4");
                userUpdateService.updateUser(selectedUser);
                System.out.println("test5");
                return "redirect:/user/account";

                /*
                Catches any email additions with are incorrectly formatted

                 */
            } catch (TransactionSystemException  e)  {
                System.out.println("testfail1");
                return "redirect:/user/account";
            }
        } else {
            System.out.println("testfail2");
            return "redirect:/user/account";
        }

    }

    @PostMapping("/change-password")
    public String changePassword(@ModelAttribute("editForm") @Valid UserEditForm nameForm,
                                 BindingResult result) {

        if(!result.hasErrors()) {

            SiteUser selectedUser = userUpdateService.findUserById(Long.parseLong(nameForm.getId())).get();
            selectedUser.setPassword(encoder.encode(nameForm.getEdit()));
            userUpdateService.updateUser(selectedUser);
        }
        return "redirect:/user/account";
    }
}
