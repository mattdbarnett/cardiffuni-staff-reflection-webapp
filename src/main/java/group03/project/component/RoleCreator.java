package group03.project.component;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleCreator {

    Optional<Role> createRole(String role, String description);
}
