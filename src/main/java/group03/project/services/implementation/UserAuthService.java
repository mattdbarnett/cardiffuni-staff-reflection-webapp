//package group03.project.services.implementation;
//
//import group03.project.domain.SiteUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserAuthService implements UserDetailsService {
//
//    @Autowired
//    private final SiteUserJPAService siteUserRepo;
//
//    @Autowired
//    public UserAuthService(SiteUserJPAService aSiteUserRepo) {
//        siteUserRepo = aSiteUserRepo;
//    }
//}
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<SiteUser> user = siteUserRepo.findUserByUsername(username);
//
//        user.orElseThrow(() -> new UsernameNotFoundException(username + "Not found in system."));
//
//        return user.map(UserAuthServiceImpl::new).get();
//        return null;
//}
