package group03.project.repositories;

import group03.project.domain.Activity;

import java.util.List;
import java.util.Set;

public interface ActivityRepository {

    List<Activity> findAll();

    Activity save(Activity theActivity);
}
