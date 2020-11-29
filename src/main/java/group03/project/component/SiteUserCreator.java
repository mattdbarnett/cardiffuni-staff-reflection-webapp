package group03.project.component;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SiteUserCreator {

    Optional<SiteUser> createUser(Long id,

                                  String nEmailAddress,
                                  String password,
                                  String Name);
}
