package group03.project.domain;

import java.util.Optional;

public interface SiteUserAuditor {

    public SiteUser addUser(SiteUser aSiteuser);

    public Optional<SiteUser> findSiteUsersById(Long id);
}
