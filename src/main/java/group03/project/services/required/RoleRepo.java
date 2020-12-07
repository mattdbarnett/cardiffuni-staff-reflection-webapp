package group03.project.services.required;

import group03.project.domain.Role;

import java.util.List;
import java.util.Optional;

/**
 * Repository used as extension of JPA Role repo .
 */
public interface RoleRepo {


    public Optional<Role> findById(String id);

    public List<Role> findAll();

    public Role save(Role aRole);
}

