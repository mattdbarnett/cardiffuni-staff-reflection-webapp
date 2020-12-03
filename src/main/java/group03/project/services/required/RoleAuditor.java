package group03.project.services.required;

import group03.project.domain.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface RoleAuditor {

    public void addRole(Role aRole);

    public List<Role> findAllRoles();

    public Optional<Role> findRoleById(String roleId);
}
