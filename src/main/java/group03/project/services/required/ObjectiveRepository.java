package group03.project.services.required;

import group03.project.domain.Objective;

import java.util.List;
import java.util.Optional;

public interface ObjectiveRepository {

    List<Objective> findAll();

    Optional<Objective> findByActivity_activityID(Long ActivityID);

    Optional<Objective> Tag_tagID(Long ActivityID);

    Objective save(Objective theObjective);


}