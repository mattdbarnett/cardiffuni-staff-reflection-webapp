package group03.project.services.required;

import group03.project.domain.Tag;

import java.util.Optional;

/**
 * Interface allowing communication by controllers to service methods connecting to database
 * for site users.
 */
public interface TagAuditor {
    /**
     * Method that creates official tag inside database
     * @param theTag - created tag object from controller.
     */
    public void createOfficialTag(Tag theTag);
    /**
     * Method that creates an unofficial tag inside database
     * @param theTag - created tag object from controller.
     */
    public void createCustomTag(Tag theTag);

    /**
     * Method finds tag by id given
     * @param id
     * @return tag matching given id.
     */
    public Optional<Tag> findATagByID(String id);

    /**
     * finds all tags marked as official.
     * @param status - true or false.
     * @return all official tags in database.
     */
    public Optional<Tag> findTagsIfOfficial(Boolean status);

    /**
     * finds all tags marked as unofficial.
     * @param status - true or false
     * @return all custom tags on database.
     */
    public Optional<Tag> findTagsIfCustom(Boolean status);
}
