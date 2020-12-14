package group03.project.services.offered;

import group03.project.domain.Activity;
import group03.project.services.required.ActivityRepository;
import group03.project.services.required.ActivityRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActivityJDBCService implements ActivityRepositoryJDBC {

    private JdbcTemplate jdbcTemplate;

    @Value("select max(activityID) from activity")
    private String lastActivityIdSQL;
    @Autowired
    public ActivityJDBCService(JdbcTemplate theTemplate) { jdbcTemplate = theTemplate; }

    @Override
    public Long findLastActivityID() {
        return jdbcTemplate.queryForObject(lastActivityIdSQL, new Object[]{}, Long.class);
    }

}
