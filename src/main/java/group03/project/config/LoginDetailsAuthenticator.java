package group03.project.config;

import group03.project.config.SiteUserPrincipal;
import group03.project.domain.SiteUser;
import group03.project.services.required.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginDetailsAuthenticator implements UserDetailsService {

    @Autowired
    SiteUserRepository siteUserRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            System.out.println("username to check: " + userName);

            Optional<SiteUser> user = siteUserRepo.findByUserName(userName);
            System.out.println("current permissions: " + user.get().getPermissions());
            user.orElseThrow(() -> new UsernameNotFoundException(userName + " cannot be found on system"));
            return user.map(SiteUserPrincipal::new).get();

        } catch (Exception s) {
            return null;
        }




    }
}
