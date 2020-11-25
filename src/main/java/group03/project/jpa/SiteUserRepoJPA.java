package group03.project.jpa;

import group03.project.domain.SiteUser;
import group03.project.repositories.SiteUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepoJPA extends JpaRepository<SiteUser, Long>, SiteUserRepository {
}
