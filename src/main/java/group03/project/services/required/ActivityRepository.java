package group03.project.services.required;

import group03.project.domain.Activity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository {

    List<Activity> findAll();

    Activity save(Activity theActivity);

    Optional<Activity> findByActivityID(Long id);

//    @Query(value = "select MAX(ActivityID) from activity", nativeQuery = true)
    public Long findLastActivityID();

    Optional<Activity> findByDescription(Long id);



}
