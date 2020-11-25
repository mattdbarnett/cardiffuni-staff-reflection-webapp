package group03.project.repositories;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;

import java.util.List;
import java.util.Optional;

public interface SiteUserRepository {

    List<SiteUser> findAll();

    Optional<SiteUser> findByRole(String role);
}
