package group03.project.web;

import group03.project.TestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserAccountTest {

    @Autowired
    private MockMvc mvc;

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



}
