package group03.project.jpa;

import group03.project.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserRepoJPA extends JpaRepository<SiteUser, Long>, SiteUserServiceJPA {
}
