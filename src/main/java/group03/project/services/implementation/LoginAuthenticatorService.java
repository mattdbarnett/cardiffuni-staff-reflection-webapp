package group03.project.services.implementation;

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
public class LoginAuthenticatorService implements UserDetailsService {

    @Autowired
    SiteUserRepository siteUserRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("loadUserByUserName called");
        try {
            System.out.println("username to check: " + userName);
            Optional<SiteUser> user = siteUserRepo.findByUserName(userName);
            System.out.println(user.get().getUserName());
            user.orElseThrow(() -> new UsernameNotFoundException(userName + " cannot be found on system"));
            System.out.println("user created: " + user.get().getUserName());
            return user.map(SiteUserPrincipal::new).get();
        } catch (Exception s) {
            System.out.println("hasn't worked!");
            return null;
        }




    }
}
