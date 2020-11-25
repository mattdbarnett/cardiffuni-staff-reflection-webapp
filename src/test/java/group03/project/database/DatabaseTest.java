package group03.project.database;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import group03.project.repositories.RoleRepository;
import group03.project.repositories.SiteUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DatabaseTest {

    @Autowired
    private SiteUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldReturnTwoUsers() throws Exception {

        List<SiteUser> siteUsers = userRepository.findAll();

        assertEquals(3, siteUsers.size());
    }

    @Test
    public void shouldReturnCEODescription() throws Exception {

        Role role = roleRepository.findByRole("CEO").get();
        assertEquals("Tells secretary what to do etc", role.getDescription());
    }
}
