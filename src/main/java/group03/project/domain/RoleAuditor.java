package group03.project.domain;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RoleAuditor {

    public void addRole(Role aRole);

    public List<Role> findAllRoles();

    public Optional<Role> findRoleById(String roleId);
}
