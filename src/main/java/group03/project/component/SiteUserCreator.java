package group03.project.component;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SiteUserCreator {

    Optional<SiteUser> createUser(Long id,
                                  String Name,
                                  String HomeAddress,
                                  String nEmailAddress,
                                  String Position,
                                  Integer PhoneNo,
                                  Role Role);
}
