package group03.project.service.implementation;

import group03.project.domain.Role;
import group03.project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleDataImpl implements RoleService {

    private final RoleRepository roleRepo;

    @Autowired
    public RoleDataImpl(RoleRepository aRoleRepo) { roleRepo = aRoleRepo; }

    @Override
    public List<Role> findAll() { return roleRepo.findAll(); }
}
