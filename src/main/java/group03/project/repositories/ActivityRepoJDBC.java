package group03.project.repositories;

import group03.project.domain.Activity;
import group03.project.services.required.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ActivityRepoJDBC implements ActivityRepository {

    private JdbcTemplate jdbcTemplate;

    @Value("select max(id) from donation")
    private String lastActivityIdSQL;
    @Autowired
    public ActivityRepoJDBC(JdbcTemplate theTemplate) { jdbcTemplate = theTemplate; }

    @Override
    public List<Activity> findAll() {
        return null;
    }

    @Override
    public Activity save(Activity theActivity) {
        return null;
    }

    @Override
    public Optional<Activity> findByActivityID(Long id) {
        return Optional.empty();
    }



    @Override
    public Optional<Activity> findByDescription(Long id) {
        return Optional.empty();
    }

    @Override
    public Long findLastActivityID() {
        return jdbcTemplate.queryForObject(lastActivityIdSQL, new Object[]{}, Long.class);
    }
}
