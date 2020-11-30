package group03.project.jpa;

import group03.project.domain.Role;
import group03.project.domain.SiteUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DatabaseTest {

    @Autowired
    private SiteUserServiceJPA userRepository;
    @Autowired
    private RoleServiceJPA roleRepository;

    @Test
    public void shouldReturnThreeUsers() throws Exception {

        List<SiteUser> siteUsers = userRepository.findAll();

        assertEquals(3, siteUsers.size());
    }

    @Test
    public void shouldReturnCEODescription() throws Exception {

        Role role = roleRepository.findById("Participant").get();
        assertEquals("participating in activity", role.getDescription());
    }
}
