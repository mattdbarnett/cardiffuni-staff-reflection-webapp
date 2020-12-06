package group03.project.services.implementation;


import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class SiteUserServiceImpl implements SiteUserService {

    @Autowired
    private final SiteUserJPAService siteUserRepo;




    @Autowired
    public SiteUserServiceImpl(SiteUserJPAService aSiteUserRepo) {
        siteUserRepo = aSiteUserRepo;
    }


//    private SiteUser validateNewUser(SiteUser newUser) { return siteUserAuditor.createUser(newUser); }


    @Override
    @Transactional
    public void createUser(SiteUser newUser) {

        siteUserRepo.createAUser(newUser);

    }

    @Override
    public void updateUser(SiteUser aSiteUser) {
        siteUserRepo.updateUser(aSiteUser);
    }

    }



