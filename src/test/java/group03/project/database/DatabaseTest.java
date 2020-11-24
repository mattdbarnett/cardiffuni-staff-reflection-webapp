package group03.project.database;

import group03.project.domain.SiteUser;
import group03.project.repositories.SiteUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "dev")
public class DatabaseTest {

    @Autowired
    private SiteUserRepository userRepository;

    @Test
    public void shouldReturnTwoUsers() throws Exception {

        List<SiteUser> siteUsers = userRepository.findAll();

        assertEquals(2, siteUsers.size());


    }
}
