package group03.project.repositories;

import group03.project.domain.SiteUser;
import group03.project.services.required.SiteUserServiceJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepoJPA extends JpaRepository<SiteUser, Long>, SiteUserServiceJPA {


}
