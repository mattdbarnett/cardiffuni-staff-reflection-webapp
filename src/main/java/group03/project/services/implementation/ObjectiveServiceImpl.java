package group03.project.services.implementation;

import group03.project.domain.Activity;
import group03.project.domain.Objective;
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
    public Optional<Objective> findObjectivesByTag(Tag theTag) {
        return Optional.empty();
    }
}
