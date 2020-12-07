package group03.project.services.required;

import group03.project.domain.SiteUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Interface allowing communication by controllers to service methods connecting to database
 * for site users.
 */
public interface SiteUserAuditor {
    /**
     * Creates a user
     * @param aSiteuser - parsed site user.
     */
    public void createUser(SiteUser aSiteuser);

    /**
     * updates site user.
     * @param aSiteuser
     */
    public void updateUser(SiteUser aSiteuser);

    /**
     * Find a user based upon their database userID
     * @param id - the parsed ID
     * @return optional list of all users with the id
     */
    public Optional<SiteUser> findUserById(Long id);

    /**
     * find all users on database
     * @return a list of all users
     */
    public List<SiteUser> findAllUsers();

    /**
     * find a user depending on the email entry string.
     * @param email - user's email
     * @return optional list containing a user if matching database entry
     */
    public Optional<SiteUser> findUserByEmail(String email);

    /**
     * find a user depending on name entry
     * @param name - user's saved name
     * @return optional list containing user(s) if matching database entry.
     */
    public Optional<SiteUser> findUserByUserName(String name);


}
