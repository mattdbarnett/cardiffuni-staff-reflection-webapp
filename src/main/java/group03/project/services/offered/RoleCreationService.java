package group03.project.services.offered;

import group03.project.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleCreationService {
    List<Role> createRole(Role aRole);
}
