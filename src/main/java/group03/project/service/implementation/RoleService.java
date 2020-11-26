package group03.project.service.implementation;

import group03.project.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAll();
}
