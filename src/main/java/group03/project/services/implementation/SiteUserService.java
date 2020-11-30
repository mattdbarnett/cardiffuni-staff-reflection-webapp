package group03.project.services.implementation;

import group03.project.domain.SiteUser;
import group03.project.services.required.SiteUserAuditor;
import group03.project.services.required.SiteUserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteUserService implements SiteUserAuditor {

    final SiteUserServiceJPA userRepoJPA;

    @Autowired
    public SiteUserService(SiteUserServiceJPA aUserRepoJPA) {userRepoJPA = aUserRepoJPA; };

    @Override
    public List<SiteUser> findAllUsers() { return userRepoJPA.findAll(); }

    @Override
    public Optional<SiteUser> findUserById(Long id) {
        return userRepoJPA.findById(id);
    }

    @Override
    public Optional<SiteUser> findUserByEmail(String email) { return userRepoJPA.findByEmailAddress(email); }

    @Override
    public Optional<SiteUser> findUserByName(String name) { return userRepoJPA.findByName(name); }

    @Override
    public void createUser(SiteUser aSiteuser) {
        userRepoJPA.save(aSiteuser);
    }

}
