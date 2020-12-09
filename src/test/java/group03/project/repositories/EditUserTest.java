package group03.project.repositories;

import group03.project.domain.SiteUser;
import group03.project.services.implementation.SiteUserServiceImpl;
import group03.project.services.offered.SiteUserService;
import group03.project.services.required.SiteUserServiceJPA;
import group03.project.web.controllers.InfoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
public class EditUserTest {


//    @Autowired
//    private MockMvc mockMvc;

    @MockBean
    SiteUserService updateService;

//    @MockBean
//    SiteUserAuditor userAuditor;

    @Autowired
    public SiteUserServiceJPA siteUserRepository;

//    @MockBean
//    public SiteUserServiceJPA userRepository;


    @Test
    public void shouldUpdateAUserNameAndEmailAddress() throws Exception {

        SiteUser ryan = new SiteUser(1L, "email@emailaddress.com", "password", "david");

        ryan.setName("ryan");
        ryan.setEmailAddress("ryan@emailaddress.com");

        updateService.updateUser(ryan);

        assertEquals("ryan", ryan.getName());
        assertEquals("ryan@emailaddress.com", ryan.getEmailAddress());

    }

    @Test
    public void shouldNotUpdateEmailAddressWithInvalidEntry() throws Exception {

        SiteUser daisy = new SiteUser(1L, "daisy", "password", "daisy");

//        Assertions.assert

        daisy.setEmailAddress("daisyDaisy");
        siteUserRepository.save(daisy);
//
//        updateService.updateUser(ryan);
//
//        assertEquals("ryan", ryan.getName());
//        assertEquals("ryan@emailaddress.com", ryan.getEmailAddress());



    }

}
