package group03.project.services.offered;

import group03.project.domain.Permission;
import group03.project.domain.SiteUser;
import org.springframework.stereotype.Service;

public interface SiteUserService {

    public void createUser(SiteUser newUser);

    public void updateUser(SiteUser user);

}
