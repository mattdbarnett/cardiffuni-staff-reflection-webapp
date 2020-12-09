package group03.project.web;


import group03.project.domain.Tag;
import group03.project.services.required.TagRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class TagWebTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TagRepository repository;

    @Test
    @DisplayName("User is presented all tags from hardcoded datasource")
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldPresentUserWithAllTags() throws Exception {

        mvc.perform(get("/user/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("A1")))
                .andExpect(content().string(containsString("Insightful")));
    }

    @Test
    @DisplayName("User adds a custom tag, and can see it on page")
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldSeeCustomTagOnPageWhenCreated() throws Exception {

        Tag newTag = new Tag(null, "test", "tester tag", false);

        repository.save(newTag);

        mvc.perform(get("/user/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("test")))
                .andExpect(content().string(containsString("tester tag")));
    }


}
