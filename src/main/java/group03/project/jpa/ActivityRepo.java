package group03.project.jpa;

import group03.project.domain.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepo extends CrudRepository<Activity, Integer> {

}
