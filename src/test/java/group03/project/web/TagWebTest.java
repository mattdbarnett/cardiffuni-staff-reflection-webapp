package group03.project.web;


import group03.project.TestSupport;
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

import javax.transaction.Transactional;

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
    @DisplayName("Admin is presented all tags from hardcoded datasource")
    @WithMockUser(username="user", password = "password1", roles = "ADMIN")
    public void shouldPresentAdminWithAllTags() throws Exception {

        mvc.perform(get("/user/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("A1")))
                .andExpect(content().string(containsString("Develop effective learning environments and approaches to student support and guidance")));
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

    @Test
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldNotSeeDeleteButtonAsUser() throws Exception {

        mvc.perform(get("/user/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(TestSupport.doesNotContainString("Remove")));

    }

    @Test
    @WithMockUser(username="user", password = "password1", roles = "ADMIN")
    public void shouldSeeDeleteButtonAsAdmin() throws Exception {

        mvc.perform(get("/admin/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Remove Tag")));

    }
    
    @Test
    @Transactional
    @WithMockUser(username="user", password = "password1", roles = "ADMIN")
    public void shouldCreateAViewableCustomTagAndDelete() throws Exception {

        Tag newTag = new Tag(1L, "a new tag test", "tester tag", false);

        repository.save(newTag);

        mvc.perform(get("/admin/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("a new tag test")));

        repository.deleteByTagID(1L);

        mvc.perform(get("/user/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(TestSupport.doesNotContainString("a new tag test")));

    }


}
