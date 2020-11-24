package group03.project.domain;

import java.util.Optional;

public interface SiteUserCreator {

    Optional<SiteUser> createUser(Long id,
                                  String aName,
                                  String aHomeAddress,
                                  String anEmailAddress,
                                  String aPosition,
                                  Integer aPhoneNo,
                                  Role aRole);
}
