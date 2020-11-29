package group03.project.jpa;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import group03.project.repository.RoleRepository;
import group03.project.repository.SiteUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DatabaseTest {

    @Autowired
    private SiteUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldReturnThreeUsers() throws Exception {

        List<SiteUser> siteUsers = userRepository.findAll();

        assertEquals(3, siteUsers.size());
    }

    @Test
    public void shouldReturnCEODescription() throws Exception {

        Role role = roleRepository.findByRole("Participant").get();
        assertEquals("participating in activity", role.getDescription());
    }
}
