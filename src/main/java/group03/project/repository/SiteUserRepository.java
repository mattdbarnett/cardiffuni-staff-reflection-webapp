package group03.project.repository;

import group03.project.domain.SiteUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SiteUserRepository {

    List<SiteUser> findAll();

    Optional<SiteUser> findById(Long id);
}
