package group03.project.services.implementation;

import group03.project.domain.Tag;
import group03.project.services.offered.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TagServiceImpl implements TagService {

    @Autowired
    private final TagJPAService tagRepo;

    public TagServiceImpl(TagJPAService theTagRepo) { tagRepo = theTagRepo; }

    @Override
    public void createOfficialTag(Tag theTag) { tagRepo.createOfficialTag(theTag);
    }
    @Override
    public void createUnofficialTag(Tag theTag) { tagRepo.createCustomTag(theTag);

    }
}
