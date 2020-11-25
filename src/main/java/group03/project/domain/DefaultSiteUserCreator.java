package group03.project.domain;

import group03.project.component.SiteUserCreator;
import group03.project.repositories.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DefaultSiteUserCreator implements SiteUserCreator {



    private final SiteUserRepository siteUserRepo;
    private final SiteUserAuditor siteUserAuditor;

    @Autowired
//    public DefaultSiteUserCreator( SiteUserAuditor aSiteUserAuditor) {
    public DefaultSiteUserCreator(SiteUserRepository aSiteUserRepo, SiteUserAuditor aSiteUserAuditor) {
        siteUserAuditor = aSiteUserAuditor;
        siteUserRepo = aSiteUserRepo;
    }

    @Override
    public Optional<SiteUser> createUser(Long id, String name, String homeAddress, String emailAddress, String position, Integer phoneNo, Role role) {


        SiteUser validateUser;
        if (id == null) {
            validateUser = new SiteUser(null, name, homeAddress, emailAddress, position, phoneNo, role);
        } else {

            validateUser = siteUserAuditor.findSiteUsersById(id).get();
            validateUser.setName(name);
            validateUser.setHomeAddress(homeAddress);
            validateUser.setEmailAddress(emailAddress);
            validateUser.setPosition(position);
            validateUser.setPhoneNo(phoneNo);
            validateUser.setRole(role);
        }
        SiteUser newUser = validateNewUser(validateUser);

        return Optional.of(newUser);




//        return Optional.empty();

    }

    private SiteUser validateNewUser(SiteUser newUser) { return siteUserAuditor.addUser(newUser); }
}
