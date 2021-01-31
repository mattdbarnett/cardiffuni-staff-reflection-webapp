package group03.project.repositories;

import group03.project.domain.SiteUser;
import group03.project.services.required.SiteUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserCreationTest {

    @Autowired
    public SiteUserRepository siteUserRepository;

    @Test
    public void addTwoAdditionalTestUsersAndCountTotal() throws Exception {

        SiteUser greg = new SiteUser("greg@hotmail.co.uk", "password", "Greg");
        SiteUser tammy = new SiteUser("tammster@outlook.com", "123pass5", "Tammy");

        siteUserRepository.save(greg);
        siteUserRepository.save(tammy);

        List<SiteUser> allUsers = siteUserRepository.findAll();

        assertEquals(14, allUsers.size());
    }

    @Test
    public void findNewCreatedUserInDatabaseByEmailAndId() throws Exception {

        SiteUser andrew = new SiteUser("andrew@gmail.co.uk", "andypandy", "Andy");

        siteUserRepository.save(andrew);

        Optional<SiteUser> userId = siteUserRepository.findById(13L);
        SiteUser convertedAndrew = userId.get();

        System.out.println(siteUserRepository.findAll());
        assertEquals("andrew@gmail.co.uk", convertedAndrew.getEmailAddress());
    }
}
