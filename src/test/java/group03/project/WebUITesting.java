package group03.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
/**
 * Informing test which components are within the test's scope (what you're testing!)
 */
@ContextConfiguration(classes = {PageController.class})
/**
 * Configures a mock mvc environment
 */
@AutoConfigureMockMvc
public class WebUITesting {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldLoadLoginPage() throws Exception {

        this.mvc
                .perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Login")));
    }
    @Test
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldLoadAboutPage() throws Exception {
        this.mvc
                .perform(get("/about"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Professional Development Tracker")));
    }

    @Test
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldLoadDashboardPage() throws Exception {
        this.mvc
                .perform(get("/dashboard"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("View my")));
    }
}
