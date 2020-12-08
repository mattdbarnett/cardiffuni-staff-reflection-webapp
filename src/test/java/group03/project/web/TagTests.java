package group03.project.web;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TagTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("User is presented all tags from hardcoded datasource")
    @WithMockUser(username="user", password = "password1", roles = "USER")
    public void shouldPresentUserWithAllTags() throws Exception {

        mvc.perform(get("/user/all-tags"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("A1")));
    }
}
