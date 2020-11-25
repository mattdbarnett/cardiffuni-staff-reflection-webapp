package group03.project.component;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface RoleCreator {

    Optional<Role> createRole(String role, String description);
}
