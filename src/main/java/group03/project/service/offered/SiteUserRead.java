package group03.project.service.offered;

import group03.project.domain.SiteUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SiteUserRead {
    List<SiteUser> findAll();
}
