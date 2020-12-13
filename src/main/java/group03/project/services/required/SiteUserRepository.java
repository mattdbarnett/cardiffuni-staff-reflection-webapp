package group03.project.services.required;

import group03.project.domain.SiteUser;

import java.util.List;
import java.util.Optional;

public interface SiteUserRepository {

     List<SiteUser> findAll();

     Optional<SiteUser> findById(Long id);

     Optional<SiteUser> findByEmailAddress(String email);

     Optional<SiteUser> findByUserName(String name);

     Optional<SiteUser> findByPermissions(String permissions);

     SiteUser save(SiteUser aSiteUser);

     void deleteById(Long theID);



}
