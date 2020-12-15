package group03.project.services.implementation;

import group03.project.domain.Activity;
import group03.project.domain.Objective;
import group03.project.domain.Participation;
import group03.project.domain.Tag;
import group03.project.services.offered.ObjectiveService;
import group03.project.services.required.ActivityRepository;
import group03.project.services.required.ObjectiveRepository;
import group03.project.services.required.SiteUserRepository;
import group03.project.services.required.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ObjectiveServiceImpl implements ObjectiveService {

//    private JdbcTemplate template;
    final ObjectiveRepository objectiveRepository;
    final TagRepository tagRepository;
    final ActivityRepository activityRepository;

//    @Value("INSERT INTO objective( Activity_activityID, Tag_tagID) values (?,?)")
//    private String newObjectiveSQL;

    @Autowired
    public ObjectiveServiceImpl(JdbcTemplate theTemplate, ObjectiveRepository objRepo, TagRepository tagRepo,
    ActivityRepository actRepo) {
//        template = theTemplate;
        objectiveRepository = objRepo;
        tagRepository = tagRepo;
        activityRepository = actRepo;
    }


    @Override
    public void createObjective(Objective theObjective) {

//        Optional<Tag> thetag = tagRepository.findByTagID(theObjective.getTag().getTagID());
//        Optional<Activity> theActivity = activityRepository.findByActivityID(theObjective.getActivity().getActivityID());
//
//

        objectiveRepository.save(theObjective);

//
//        template.update(
//                con -> {
//                    PreparedStatement statement =
//                            con.prepareStatement(newObjectiveSQL, Statement.RETURN_GENERATED_KEYS);
//
//                    statement.setLong(1, theActivity.get().getActivityID());
//                    statement.setLong(2, thetag.get().getTagID());
//                    return statement;
//                },
//                keyHolder);



    }

    @Override
    public Optional<Objective> findObjectivesByActivity(Activity theActivity) {
        return Optional.empty();
    }

    @Override
    public Optional<Objective> findObjectivesByTagID(Long theID) { return objectiveRepository.findByTag_tagID(theID); }

    @Override
    public Optional<Objective> findObjectivesByActivityID(Long theID) { return objectiveRepository.findByActivity_activityID(theID);
    }

    //gets list size of objectives list
    @Override
    public Integer getObjectiveListSize() {
        List<Objective> objective = new ArrayList<>();
        objectiveRepository.findAll().forEach(objective::add);
        return objective.size();
    }

    //gets all objectives
    @Override
    public List<Objective> getAllObjectives() {
        List<Objective> objectives = new ArrayList<>();
        objectiveRepository.findAll().forEach(objectives::add);
        return objectives;
    }

    //gets associated activity
    @Override
    public Activity getAssociatedActivity(Objective objective) {

        Activity foundActivity = new Activity();
        List<Activity> activities = activityRepository.findAll();
        for (Activity newActivity : activities) {

        }
        for(int x = 0; x < activities.size(); x++) {
            Activity currentActivity = (activities.get(x));
            if(currentActivity.getActivityID() == objective.getActivity().getActivityID()) {
                foundActivity = currentActivity;
            }
        }
        return foundActivity;
    }

}
