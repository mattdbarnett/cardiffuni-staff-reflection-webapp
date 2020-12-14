package group03.project.repositories;

import group03.project.domain.Tag;
import group03.project.services.required.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TagCreationTest {
    @Autowired
    public TagRepository tagRepository;

    @Test
    public void AddOneTagToListOfTags() throws Exception {

        Tag tag1 = new Tag(null, "b12", "a new tag", true);


        tagRepository.save(tag1);

        Optional<Tag> theTag = tagRepository.findByTagName("b12");
        System.out.println(theTag);

        assertEquals("b12", theTag.get().getTagName());
    }

    @Test
    public void addThreeTagsAndSearchByOfficialStatus() throws Exception {

        Tag tag1 = new Tag(null, "b12", "a new tag", true);
        Tag tag2 = new Tag(null, "c8", "a newer tag", false);
        Tag tag3 = new Tag(null, "A6", "the newest tag", true);


        tagRepository.save(tag1);
        tagRepository.save(tag2);
        tagRepository.save(tag3);

        List<Tag> allOfficialTags = tagRepository.findByIsOfficial(true);
        List<Tag> allCustomTags = tagRepository.findByIsOfficial(false);
        // Correct with fresh database.
        assertEquals(18, allOfficialTags.size());
        // Correct with fresh database.
        assertEquals(17, allCustomTags.size());
    }
}
