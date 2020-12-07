package group03.project.services.implementation;

import group03.project.domain.Tag;
import group03.project.services.required.TagService;
import group03.project.services.required.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagJPAService implements TagService {

    final TagRepository tagJPAConnector;

    @Autowired
    public TagJPAService(TagRepository theJPATagConnector) {
        tagJPAConnector = theJPATagConnector; };

    @Override
    public void createOfficialTag(Tag theTag) {

        theTag.setIsOfficial(true);
        tagJPAConnector.save(theTag);
    }

    @Override
    public void createCustomTag(Tag theTag) {

        tagJPAConnector.save(theTag);

    }

    @Override
    public Optional<Tag> findATagByID(String id) { return tagJPAConnector.findById(id); }

    @Override
    public List<Tag> findTagsIfOfficial() {
        return tagJPAConnector.findByIsOfficial(true);
    }

    @Override
    public List<Tag> findTagsIfCustom() {
        return tagJPAConnector.findByIsOfficial(false);
    }

}
