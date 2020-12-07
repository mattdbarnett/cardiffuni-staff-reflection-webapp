package group03.project.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        mvc.perform(get("/user/account/2")).andExpect(status().is(200));
    }

    @Test
    @DisplayName("302 redirect occurs when entering account without authentication")
    public void shouldNotAllowUserWhenAttemptingAccessToProfile() throws Exception {
        mvc.perform(get("/account/2")).andExpect(status().is(401));
    }

//    @Test
//    @DisplayName("when calling link endpoint with correct authentication, receive 200 code with no issues")
//    @WithMockUser


}
