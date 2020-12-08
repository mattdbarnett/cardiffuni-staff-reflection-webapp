package group03.project.config;

import group03.project.domain.SiteUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteUserPrincipal implements UserDetails {

    private String userName;
    private String password;
    private Boolean active;
    private List<GrantedAuthority> authorities;

    public SiteUserPrincipal(SiteUser user) {

        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = Boolean.TRUE;
        this.authorities = Arrays.stream(user.getPermissions().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return userName;
    
    
    }
    @Override
    public String getPassword() {
        return password;
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
