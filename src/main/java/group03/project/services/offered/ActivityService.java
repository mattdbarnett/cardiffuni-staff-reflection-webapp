package group03.project.services.offered;

import group03.project.domain.Activity;
import group03.project.domain.SiteUser;

import java.util.List;
import java.util.Optional;

public interface ActivityService {


    public Optional<Activity> findActivitiesByID(Long id);

    public List<Activity> findAllActivities();

    public void saveActivity(Activity theActivity);

    int getActivityListSize();
}
