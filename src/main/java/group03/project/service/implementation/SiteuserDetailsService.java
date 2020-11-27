//package group03.project.service.implementation;
//
//import group03.project.domain.SiteUser;
//import group03.project.repositories.RoleRepository;
//import group03.project.repositories.SiteUserRepository;
//import group03.project.web.NewUserForm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SiteuserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private SiteUserRepository userRepo;
//
//    @Autowired
//    private RoleRepository roleRepo;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//
//    private SiteUser registerNewUser(NewUserForm userForm) {
//
//        return new SiteUser(userForm.getEmailAddress(), userForm.getName(), userForm.getPassword());
//    }
//}
