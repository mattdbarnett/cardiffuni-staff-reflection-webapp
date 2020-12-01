package group03.project.services.implementation;

import group03.project.domain.Role;
import group03.project.services.required.RoleAuditor;
import group03.project.services.required.RoleServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements RoleAuditor {

    final RoleServiceJPA roleRepoJPA;

    @Autowired
    public RoleService(RoleServiceJPA aUserRepoJPA) {roleRepoJPA = aUserRepoJPA; };


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
