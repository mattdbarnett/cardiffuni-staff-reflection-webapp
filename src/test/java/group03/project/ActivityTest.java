package group03.project;

import group03.project.domain.Activity;
import group03.project.services.implementation.ActivityService;
import group03.project.web.controllers.ActivityController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void shouldAddActivity() throws Exception {

        List<Activity> activities = new ArrayList<>(Arrays.asList(
                new Activity(0, "Example Name 1", "Example File", "Example Desc"),
                new Activity(1, "Example Name 2", "Example File", "Example Desc")
        ));

        when(activityService.getActivityListSize())
                .thenReturn(activities.size());

        //Adding via post request without errors
        MvcResult result = mvc.perform(post("/add_official_activity")
                .contentType(APPLICATION_FORM_URLENCODED) //from MediaType
                .param("name", activities.get(0).getName())
                .param("file", activities.get(0).getFile())
                .param("desc", activities.get(0).getDesc()))
                .andReturn();

        //Adding via service without errors
        activityService.save(activities.get(1));

        assertEquals(2, activityService.getActivityListSize());
    }

    @Test
    public void shouldAddCustomActivity() throws Exception {

        List<Activity> activities = new ArrayList<>(Arrays.asList(new Activity(0, "Example Name 1", "Example File", "Example Desc")));

        when(activityService.getActivityListSize())
                .thenReturn(activities.size());

        //Adding via custom activity post request without errors
        MvcResult result = mvc.perform(post("/add_custom_activity")
                .contentType(APPLICATION_FORM_URLENCODED) //from MediaType
                .param("name", activities.get(0).getName())
                .param("file", activities.get(0).getFile())
                .param("desc", activities.get(0).getDesc()))
                .andReturn();

        assertEquals(1, activityService.getActivityListSize());
    }

}


