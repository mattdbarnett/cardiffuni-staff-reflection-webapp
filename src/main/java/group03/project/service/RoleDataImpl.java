package group03.project.service;

import group03.project.domain.Role;
import group03.project.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDataImpl implements RoleService {

    private final RoleRepository roleRepo;

    @Autowired
    public RoleDataImpl(RoleRepository aRoleRepo) { roleRepo = aRoleRepo; }

    @Override
    public List<Role> findAll() { return roleRepo.findAll(); }
}
