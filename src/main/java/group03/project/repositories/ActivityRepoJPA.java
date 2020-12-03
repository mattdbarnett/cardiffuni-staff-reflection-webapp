package group03.project.jpa;

import group03.project.domain.Activity;
import group03.project.repositories.ActivityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepoJPA extends JpaRepository<Activity, Integer>, ActivityRepository {

}
