package group03.project.repositories;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import group03.project.services.required.RoleRepository;
import group03.project.services.required.SiteUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ContextConfiguration
public class DatabaseTest {

    @Autowired
    private SiteUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldReturn12Users() throws Exception {

        List<SiteUser> siteUsers = userRepository.findAll();

        assertEquals(12, siteUsers.size());
    }

    @Test
    public void shouldReturnParticipantDescription() throws Exception {

        Role role = roleRepository.findById("Participant").get();
        assertEquals("participating in activity", role.getDescription());
    }
}
