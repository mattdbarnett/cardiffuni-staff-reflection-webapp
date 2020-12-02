package group03.project.services.implementation;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserUpdateService;
import group03.project.services.required.SiteUserAuditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SiteUserUpdateServiceImpl implements SiteUserUpdateService {

    @Autowired
    private final SiteUserService siteUserRepo;
//    @Autowired
//    private final SiteUserAuditor siteUserAuditor;

//    public SiteUserUpdateServiceImpl(SiteUserService aUserService, SiteUserAuditor anAuditor) {
    public SiteUserUpdateServiceImpl(SiteUserService aUserService) {
        siteUserRepo = aUserService;
//        siteUserAuditor = anAuditor;
    }

    @Override
    public void updateUser(SiteUser aSiteUser) {

        siteUserRepo.updateUser(aSiteUser);
    }
//
//        SiteUser validateUser;
//        if (id == null) {
//            validateUser = new SiteUser(null, emailAddress, password, name);
//        } else {
//
//            validateUser = siteUserAuditor.findUserById(id).get();
//
//            if (emailAddress != null) { validateUser.setEmailAddress(emailAddress); }
//            if (password != null) { validateUser.setPassword(password); }
//            if (name != null) {validateUser.setName(name); }
//        }
//
//        return validateUser;
//
//    }

}
