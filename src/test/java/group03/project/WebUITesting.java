package group03.project;

import group03.project.services.implementation.SiteUserJPAService;
import group03.project.services.offered.SiteUserService;
import group03.project.services.required.SiteUserAuditor;
import group03.project.web.controllers.InfoAdminController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
@ContextConfiguration(classes = {PageController.class, InfoAdminController.class})
/**
 * Configures a mock mvc environment
 */

@MockBean(SiteUserService.class)
@MockBean(SiteUserAuditor.class)
@MockBean(SiteUserJPAService.class)
@MockBean(InfoAdminController.class)

@AutoConfigureMockMvc
public class WebUITesting {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser
    public void shouldLoadLoginPage() throws Exception {
        this.mvc
                .perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("login")));
    }
    @Test
    @WithMockUser
    public void shouldLoadAboutPage() throws Exception {
        this.mvc
                .perform(get("/about"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Professional Development Tracker")));
    }

    @Test
    @WithMockUser
    public void shouldLoadDashboardPage() throws Exception {
        this.mvc
                .perform(get("/dashboard"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("View my")));
    }

    @Test
    @WithMockUser()
    public void shouldLoadAdminPages() throws Exception {
        this.mvc
                .perform(get("/admin/all-accounts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("All Users on Record (admin)")));

    }
}
