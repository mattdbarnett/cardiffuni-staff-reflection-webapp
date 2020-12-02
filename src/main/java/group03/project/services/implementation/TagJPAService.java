package group03.project.services.implementation;

import group03.project.domain.Tag;
import group03.project.services.required.TagAuditor;
import group03.project.services.required.TagServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagJPAService implements TagAuditor {

    final TagServiceJPA tagJPAConnector;

    @Autowired
    public TagJPAService(TagServiceJPA theJPATagConnector) {
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
    public Optional<Tag> findTagsIfOfficial() {
        return tagJPAConnector.findByIsOfficial(true);
    }

    @Override
    public Optional<Tag> findTagsIfCustom() {
        return tagJPAConnector.findByIsOfficial(false);
    }

}
