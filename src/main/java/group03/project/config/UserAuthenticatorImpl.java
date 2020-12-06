//package group03.project.config;
//
//import group03.project.domain.SiteUser;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//public class UserAuthenticatorImpl implements UserDetails {
//
//    private static final long sVersionUID = 1L;
//
//    private String username;
//    private String password;
//    private Boolean enabled;
//    private List<GrantedAuthority> authorityList;
//
//    public UserAuthenticatorImpl(SiteUser theUser) {
//        System.out.println("userDetails object constructor called");
//        this.username = theUser.getUsername();
//        this.password = theUser.getPassword();
//        this.enabled = true;
//        this.authorityList = Arrays.asList(new SimpleGrantedAuthority(theUser.getPermissions()));
////
////                Arrays
////                .stream(theUser.getPermissions().split(","))
////                .map(SimpleGrantedAuthority::new)
////                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorityList;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
