package group03.project.domain;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SiteUserCreator {

    Optional<SiteUser> createUser(Long id,
                                  String aName,
                                  String aHomeAddress,
                                  String anEmailAddress,
                                  String aPosition,
                                  Integer aPhoneNo,
                                  Role aRole);
}
