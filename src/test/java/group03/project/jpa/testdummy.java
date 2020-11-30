//package group03.project.jpa;
//
//import group03.project.domain.Role;
//import group03.project.domain.SiteUser;
//import group03.project.repositories.RoleRepository;
//import group03.project.repositories.SiteUserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//public class testdummy {
//
//    @Autowired
//    private SiteUserServiceJPA userRepository;
//
//    @Test
//    public void shouldAddAUserAndBeViewableInDatabase() throws Exception {
//
//
//
//
//        SiteUser newSiteUser = new SiteUser("greg@hotmail.co.uk", "password");
//
//        assertEquals(1, userRepository.findAll());
//
////        assertEquals("SECRETARY", newSiteUser.getRole().toString().toUpperCase());
//
//    }
//
//    @Test
//    public void shouldReturnFiveUsers() throws Exception {
//
//        List<SiteUser> allSiteUsers = userRepository.findAll();
//        assertEquals(5, allSiteUsers.size());
//
//
//    }
//
//}
