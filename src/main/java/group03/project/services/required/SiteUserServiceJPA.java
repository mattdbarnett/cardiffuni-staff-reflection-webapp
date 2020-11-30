package group03.project.services.required;

import group03.project.domain.SiteUser;

import java.util.List;
import java.util.Optional;

public interface SiteUserServiceJPA {

    public List<SiteUser> findAll();

    public Optional<SiteUser> findById(Long id);

    public Optional<SiteUser> findByEmailAddress(String email);

    public Optional<SiteUser> findByName(String name);

    public SiteUser save(SiteUser aSiteUser);


}
