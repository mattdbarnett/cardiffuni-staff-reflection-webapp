package group03.project.jpa;

import group03.project.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepoJPA extends JpaRepository <Role, String>, RoleServiceJPA {
}
