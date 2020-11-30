//package group03.project.service.implementation;
//
//import group03.project.domain.SiteUser;
//import group03.project.repository.SiteUserRepository;
//import group03.project.service.offered.SiteUserRead;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class SiteUserDataImpl implements SiteUserRead {
//
//    private SiteUserRepository siteUserRepo;
//
//    @Autowired
//    public SiteUserDataImpl(SiteUserRepository aSiteUserRepo) { siteUserRepo = aSiteUserRepo; }
//
//    @Override
//    public List<SiteUser> findAll() { return siteUserRepo.findAll(); }
//}
