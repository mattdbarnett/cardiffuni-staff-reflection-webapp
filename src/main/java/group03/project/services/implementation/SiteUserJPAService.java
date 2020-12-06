package group03.project.services.implementation;

import group03.project.domain.SiteUser;
import group03.project.services.required.SiteUserAuditor;
import group03.project.services.required.SiteUserServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteUserJPAService implements SiteUserAuditor {

    final SiteUserServiceJPA userRepoJPA;

    @Autowired
    public SiteUserJPAService(SiteUserServiceJPA aUserRepoJPA) {
        userRepoJPA = aUserRepoJPA;
    };

    @Override
    public List<SiteUser> findAllUsers() { return userRepoJPA.findAll(); }

    @Override
    public Optional<SiteUser> findUserById(Long id) {
        return userRepoJPA.findById(id);
    }

    @Override
    public Optional<SiteUser> findUserByEmail(String email) { return userRepoJPA.findByEmailAddress(email); }

    @Override
    public Optional<SiteUser> findUserByUsername(String userName) { return userRepoJPA.findByUserName(userName); }




    @Override
    public void updateUser(SiteUser user) {

        Optional<SiteUser> userToAmend = userRepoJPA.findById(user.getUserID());

//        SiteUser userAmend = new SiteUser(user.)

        userToAmend.ifPresent(currentUser -> {
                    currentUser.setEmailAddress(user.getEmailAddress());
                    currentUser.setPassword(user.getPassword());
                    currentUser.setUserName(user.getUserName());
                });


        userRepoJPA.save(userToAmend.get());
    }

    @Override
    public void createAUser(SiteUser aSiteuser) { userRepoJPA.save(aSiteuser); }


}
