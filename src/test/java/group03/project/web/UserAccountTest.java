package group03.project.web;

import group03.project.TestSupport;

import group03.project.domain.SiteUser;
import group03.project.services.required.SiteUserRepository;
import group03.project.services.required.TagRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.Optional;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UserAccountTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private SiteUserRepository repository;

    @Test
    @DisplayName("302 redirect occurs when entering account without authentication")
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldAcceptUserWhenAttemptingAccessToProfile() throws Exception {
        mvc.perform(get("/user/account")).andExpect(status().is(200));
    }

    @Test
    @DisplayName("302 redirect occurs when entering account without authentication")
    public void shouldDeclineUserWhenAttemptingAccessToProfile() throws Exception {
        mvc.perform(get("/user/account")).andExpect(status().is(302));
    }

    @Test
    @DisplayName("user has access to dashboard page on login")
    @WithMockUser(username = "user", password = "password1", roles = "USER")
    public void shouldSeeDashboardPageOnLogin() throws Exception {

        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(a);
        SecurityContextHolder.setContext(securityContext);

        mvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("View my")));
    }

    @Test
    @DisplayName("user cannot see admin 'tag (admin)' button page on dashboard")
    @WithMockUser(username = "user", password = "password1", roles = "USER")
    public void shouldNotSeeAdminSpecificButtonOnDashboard() throws Exception {

        mvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().string(TestSupport.doesNotContainString("Tag (admin)")));

    }


    @Test
    @DisplayName("Admin user can see admin 'view all' page on dashboard")
    @WithMockUser(username = "admin", password = "password1", roles = "ADMIN")
    public void shouldSeeAdminPageDetailsOnLogin() throws Exception {

        mvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tag (admin)")));

    }

    @Test
    @Transactional
    @DisplayName("New account can be deleted by admin and ensure all-accounts page has removed entry")
    @WithMockUser(username = "admin", password = "password1", roles = "ADMIN")
    public void shouldNotFindUserWhenDeleteMethodPerformed() throws Exception {

        SiteUser andrew = new SiteUser("andrew@gmail.co.uk", "andypandy", "Andy");

        repository.save(andrew);

        mvc.perform(get("/admin/all-accounts"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Andy")));

        repository.deleteById(andrew.getUserID());

        mvc.perform(get("/admin/all-accounts"))
                .andExpect(status().isOk())
                .andExpect(content().string(TestSupport.doesNotContainString("andypandy")));


    }

    @Test
    @DisplayName("User can see a chart of their tags on dashboard")
    @WithMockUser(username = "user", password = "password1", roles = "USER")
    public void shouldSeeChartOnDash() throws Exception {

        mvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("id=\"doughnutChart\"")));

    }

    @Test
    @DisplayName("User can see a chart of their uncompleted tags on dashboard")
    @WithMockUser(username = "user", password = "password1", roles = "USER")
    public void shouldSeeSecondChartOnDash() throws Exception {

        mvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("id=\"totalProgressChart\"")));

    }
}
