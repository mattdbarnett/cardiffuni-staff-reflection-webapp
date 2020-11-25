package group03.project.domain;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface RoleAuditor {

    public Role addRole(Role aRole);

    public Optional<Role> findRoleById(String role);
}
