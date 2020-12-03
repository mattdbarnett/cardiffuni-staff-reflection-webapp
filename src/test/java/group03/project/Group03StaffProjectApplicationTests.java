package group03.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
class Group03StaffProjectApplicationTests {

	@Test
	@WithMockUser("nick")
	void contextLoads() {
	}

}
