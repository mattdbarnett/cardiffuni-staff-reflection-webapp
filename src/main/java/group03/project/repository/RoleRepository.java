package group03.project.repository;

import group03.project.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {

    List<Role> findAll();

    Optional<Role> findByRole(String role);

}
