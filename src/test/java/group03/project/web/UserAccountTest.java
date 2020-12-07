package group03.project.web;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

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
    public void shouldAllowUserWhenAttemptingAccessToProfile() throws Exception {
        mvc.perform(get("/user/account/user")).andExpect(status().is(200));
    }

    @Test
    @DisplayName("302 redirect occurs when entering account without authentication")
    public void shouldNotAllowUserWhenAttemptingAccessToProfile() throws Exception {
        mvc.perform(get("/user/account/2")).andExpect(status().is(302));
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
    @DisplayName("user cannot see admin 'view all' page on dashboard")
    @WithMockUser(username = "user", password = "password1", roles = "USER")
    public void shouldntSeeAdminDashboardButtonsOnLogin() throws Exception {

    mvc.perform(get("/dashboard"))
            .andExpect(status().isOk())
            .andExpect(content().string(doesNotContainString("Tag (admin)")));

    }
    /*
    Code adapted from StackOverflow answer:-
    User: Michael W
    Question: "Spring MockMvc don't expect content"
    URL: https://stackoverflow.com/questions/56657018/spring-mockmvc-dont-expect-content?fbclid=IwAR1OLVXC0Bb8oD35tRUrBDgt8e0IGyatBmAJDhxrDLEMs5FACUubI8kTuJc
     */

    private Matcher<String> doesNotContainString(String s) {
        return CoreMatchers.not(containsString(s));
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
