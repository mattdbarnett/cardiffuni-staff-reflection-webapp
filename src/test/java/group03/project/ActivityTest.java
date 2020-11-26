package group03.project;

import group03.project.service.ActivityService;
import group03.project.web.ActivityController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Mock environment
 */
@WebMvcTest
/**
 * Informing test which components are within the test's scope (what you're testing!)
 */
@ContextConfiguration(classes = {ActivityController.class})
/**
 * Configures a mock mvc environment
 */
@AutoConfigureMockMvc
public class ActivityTest {

    @MockBean
    private ActivityService activityService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldLoadAddOfficialActivityPage() throws Exception {

        this.mvc
                .perform(get("/add_official_activity"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Official Activity Registration")));
    }

}


