package group03.project.web;

import group03.project.services.offered.ActivityService;
import group03.project.services.offered.ObjectiveService;
import group03.project.services.offered.TagService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WebParticipationsTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ActivityService actService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ObjectiveService objectiveService;

    @Test
    @WithMockUser(value = "user", password = "password", roles = "USER")
    @DisplayName("User is presented with headers on participation page open")
    public void shouldHaveCustomThoughtsPresent() throws Exception {

        this.mvc
                .perform(get("/user/all-participations"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Initial thoughts")))
                .andExpect(content().string(containsString("Motivational")));
    }

}
