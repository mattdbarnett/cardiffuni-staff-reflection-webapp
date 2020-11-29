package group03.project.service.implementation;

import group03.project.component.SiteUserCreator;
import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import group03.project.domain.SiteUserAuditor;
import group03.project.repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SiteUserAccountService implements SiteUserCreator {



    private final SiteUserRepository siteUserRepo;
    private final SiteUserAuditor siteUserAuditor;

    @Autowired
//    public DefaultSiteUserCreator( SiteUserAuditor aSiteUserAuditor) {
    public SiteUserAccountService(SiteUserRepository aSiteUserRepo, SiteUserAuditor aSiteUserAuditor) {
        siteUserAuditor = aSiteUserAuditor;
        siteUserRepo = aSiteUserRepo;
    }

    @Override
    public Optional<SiteUser> createUser(Long id, String emailAddress, String password, String name) {


        SiteUser validateUser;
        if (id == null) {
            validateUser = new SiteUser(null, emailAddress, password, name);
        } else {

            validateUser = siteUserAuditor.findSiteUsersById(id).get();

            validateUser.setEmailAddress(emailAddress);
            validateUser.setPassword(password);
            validateUser.setName(name);
        }
        SiteUser newUser = validateNewUser(validateUser);

        return Optional.of(newUser);

    }

    private SiteUser validateNewUser(SiteUser newUser) { return siteUserAuditor.addUser(newUser); }
}
