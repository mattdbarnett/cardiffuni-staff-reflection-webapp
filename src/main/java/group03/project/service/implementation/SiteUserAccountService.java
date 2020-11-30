package group03.project.service.implementation;

import group03.project.component.SiteUserCreator;
import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import group03.project.domain.SiteUserAuditor;
import group03.project.repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SiteUserAccountService {

    public void createUser(SiteUser newUser);


}
