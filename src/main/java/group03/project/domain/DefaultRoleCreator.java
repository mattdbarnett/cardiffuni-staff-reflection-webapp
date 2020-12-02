//package group03.project.domain;
//
//import group03.project.component.RoleCreator;
//import group03.project.service.implementation.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//
//public class DefaultRoleCreator implements RoleCreator {
//
//
//
//    private final RoleRepository roleRepo;
//    private final RoleAuditor roleAuditor;
//
//    @Autowired
//    public DefaultRoleCreator(RoleRepository aRoleRepo, RoleAuditor aSiteUserAuditor) {
//        roleAuditor = aSiteUserAuditor;
//        roleRepo = aRoleRepo;
//    }
//
//    @Override
//    public Optional<Role> createRole(String role, String description) {
//
//        Role validateRole;
//        if (role == null) {
//            validateRole = new Role(role, description);
//        } else {
//
//            validateRole = roleAuditor.findRoleById(role).get();
//            validateRole.setDescription(description);
//        }
//        Role newRole = validateNewRole(validateRole);
//
//        return Optional.of(newRole);
//    }
//
//    private Role validateNewRole(Role newRole) { return roleAuditor.addRole(newRole); }
//}
