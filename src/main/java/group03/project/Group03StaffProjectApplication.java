package group03.project;

import group03.project.repositories.SiteUserRepoJPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Group03StaffProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group03StaffProjectApplication.class, args);
	}

}
