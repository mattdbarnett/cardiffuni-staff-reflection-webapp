package group03.project.repository;

import group03.project.domain.Role;
import group03.project.domain.RoleAuditor;
import group03.project.jpa.RoleServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleRepository implements RoleAuditor {

    final RoleServiceJPA roleRepoJPA;

    @Autowired
    public RoleRepository(RoleServiceJPA aUserRepoJPA) {roleRepoJPA = aUserRepoJPA; };


    @Override
    public void addRole(Role aRole) {
        roleRepoJPA.save(aRole);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepoJPA.findAll();
    }


    @Override
    public Optional<Role> findRoleById(String roleId) {
        return roleRepoJPA.findById(roleId);
    }
}
