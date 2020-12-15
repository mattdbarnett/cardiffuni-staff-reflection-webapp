package group03.project.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
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
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class ReflectionWebTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username="admin", password="pass", roles="ADMIN")
    public void loadAdminPublicReflections() throws Exception {

        this.mvc
                .perform(get("/admin/all-public-reflections"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("All Public Reflections")));
    }
}
