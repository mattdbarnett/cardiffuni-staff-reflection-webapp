package group03.project.service;

import group03.project.domain.SiteUser;
import group03.project.repositories.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteUserDataImpl implements SiteUserService {

    private SiteUserRepository siteUserRepo;

    @Autowired
    public SiteUserDataImpl(SiteUserRepository aSiteUserRepo) { siteUserRepo = aSiteUserRepo; }

    @Override
    public List<SiteUser> findAll() { return siteUserRepo.findAll(); }
}
