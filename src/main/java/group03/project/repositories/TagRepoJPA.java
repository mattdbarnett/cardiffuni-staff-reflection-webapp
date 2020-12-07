package group03.project.repositories;

import group03.project.domain.Tag;
import group03.project.services.required.TagRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepoJPA extends JpaRepository<Tag, String>, TagRepository {
}
