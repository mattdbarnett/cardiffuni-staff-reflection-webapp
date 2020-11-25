package group03.project.domain;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SiteUserAuditor {

    public SiteUser addUser(SiteUser aSiteuser);

    public Optional<SiteUser> findSiteUsersById(Long id);
}
