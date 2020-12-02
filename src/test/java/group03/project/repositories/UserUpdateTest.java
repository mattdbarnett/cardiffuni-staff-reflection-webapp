package group03.project.repositories;

import group03.project.domain.SiteUser;
import group03.project.services.offered.SiteUserService;
import group03.project.services.required.SiteUserServiceJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@DataJpaTest
public class UserUpdateTest {


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

}
