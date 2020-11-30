package group03.project.services.implementation;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserCreationService;
import group03.project.services.required.SiteUserAuditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class SiteUserCreationServiceImpl implements SiteUserCreationService {

    @Autowired
    private final SiteUserService siteUserRepo;
    @Autowired
    private final SiteUserAuditor siteUserAuditor;


    @Autowired
    public SiteUserCreationServiceImpl(SiteUserService aSiteUserRepo, SiteUserAuditor aSiteUserAuditor) {
        siteUserAuditor = aSiteUserAuditor;
        siteUserRepo = aSiteUserRepo;
    }



    public Optional<SiteUser> updateUser(Long id, String emailAddress, String password, String name) {

        SiteUser validateUser;
        if (id == null) {
            validateUser = new SiteUser(null, emailAddress, password, name);
        } else {

            validateUser = siteUserAuditor.findUserById(id).get();

            validateUser.setEmailAddress(emailAddress);
            validateUser.setPassword(password);
//            validateUser.setName(name);
        }

        return Optional.of(validateUser);

    }

//    private SiteUser validateNewUser(SiteUser newUser) { return siteUserAuditor.createUser(newUser); }


    @Override
    @Transactional
    public void createUser(SiteUser newUser) {

        siteUserRepo.createUser(newUser);

    }
}
