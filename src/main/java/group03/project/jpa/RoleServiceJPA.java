package group03.project.jpa;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository used as extension of JPA Role repo .
 */
public interface RoleServiceJPA {


    public Optional<Role> findById(String id);

    public List<Role> findAll();

    public Role save(Role aRole);
}

