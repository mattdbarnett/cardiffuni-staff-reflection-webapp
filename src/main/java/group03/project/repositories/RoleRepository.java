package group03.project.repositories;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository {

    List<Role> findAll();

    Optional<Role> findByRole(String role);
}
