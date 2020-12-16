package group03.project.web;

import group03.project.domain.Activity;
import group03.project.domain.Objective;
import group03.project.domain.Participation;
import group03.project.services.offered.ActivityService;
import group03.project.services.offered.ObjectiveService;
import group03.project.services.offered.ParticipationService;
import group03.project.services.offered.TagService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

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
    private ObjectiveService objService;
    @Autowired
    private ParticipationService partService;

    @Test
    @WithMockUser(username = "user", password = "password1", roles = "USER")
    @DisplayName("User is presented with headers on participation page open")
    public void shouldHaveCustomThoughtsPresent() throws Exception {

        java.util.Date date = new java.util.Date();

        Activity anActivity =  new Activity( "Example Name 1",  "Example Desc" );
        actService.saveActivity(anActivity);
        System.out.println("TEST");
        System.out.println(actService.findActivityByName("Example Name 1").get());
        System.out.println("TEST");

        Objective relatedObjective = new Objective(
                actService.findActivityByName("Example Name 1").get(),
                tagService.findATagByName("Motivational").get());
        Participation testParticipation = new Participation(null, relatedObjective.getActivity().getActivityID(), date, "Participant", 1L);

        actService.saveActivity(anActivity);
        objService.createObjective(relatedObjective);
        partService.createParticipation(testParticipation);

        System.out.println(partService.findAllParticipations());


        this.mvc
                .perform(get("/user/all-my-participations"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Activity UKPSF tags")))
                .andExpect(content().string(containsString("Your Activity Thoughts")));
    }

}
