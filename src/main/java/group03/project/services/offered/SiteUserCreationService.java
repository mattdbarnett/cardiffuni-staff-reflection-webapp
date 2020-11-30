package group03.project.services.offered;

import group03.project.domain.SiteUser;
import org.springframework.stereotype.Service;

@Service
public interface SiteUserCreationService {

    public void createUser(SiteUser newUser);


}
