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
    public SiteUserCreationServiceImpl(SiteUserService aSiteUserRepo) {
        siteUserRepo = aSiteUserRepo;
    }


//    private SiteUser validateNewUser(SiteUser newUser) { return siteUserAuditor.createUser(newUser); }


    @Override
    @Transactional
    public void createUser(SiteUser newUser) {

        siteUserRepo.createUser(newUser);

    }
}
