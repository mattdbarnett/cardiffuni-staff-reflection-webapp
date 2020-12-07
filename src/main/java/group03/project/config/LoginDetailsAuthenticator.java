package group03.project.config;

import group03.project.config.SiteUserPrincipal;
import group03.project.domain.SiteUser;
import group03.project.services.required.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
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

            Optional<SiteUser> user = siteUserRepo.findByUserName(userName);
            user.orElseThrow(() -> new UsernameNotFoundException(userName + " cannot be found on system"));
            return user.map(SiteUserPrincipal::new).get();


    }
}
