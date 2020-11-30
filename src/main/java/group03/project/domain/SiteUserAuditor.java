package group03.project.domain;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface SiteUserAuditor {

    public void createUser(SiteUser aSiteuser);

    public Optional<SiteUser> findUserById(Long id);

    public List<SiteUser> findAllUsers();

    public Optional<SiteUser> findUserByEmail(String email);

    public Optional<SiteUser> findUserByName(String name);
}
