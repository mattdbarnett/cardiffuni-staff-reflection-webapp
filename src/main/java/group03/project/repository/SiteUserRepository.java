package group03.project.repository;

import group03.project.domain.SiteUser;
import group03.project.domain.SiteUserAuditor;
import group03.project.jpa.SiteUserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteUserRepository implements SiteUserAuditor {

    final SiteUserServiceJPA userRepoJPA;

    @Autowired
    public SiteUserRepository(SiteUserServiceJPA aUserRepoJPA) {userRepoJPA = aUserRepoJPA; };

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
