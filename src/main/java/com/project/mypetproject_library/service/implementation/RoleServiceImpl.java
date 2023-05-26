package com.project.mypetproject_library.service.implementation;


import com.project.mypetproject_library.exception.NotFoundException;
import com.project.mypetproject_library.exception.NullEntityReferenceException;
import com.project.mypetproject_library.models.Role;
import com.project.mypetproject_library.repository.RoleRepository;
import com.project.mypetproject_library.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        logger.info("Creating new role with id {}", role.getId());
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(Long id) {
        logger.info("Getting role with id {}", id);
        return roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role with id " + id + " was not found"));
    }

    @Override
    public List<Role> getAllRoles() {
        logger.info("Getting all roles");
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Long id, Role role) {
        logger.info("Updating role with id {}", id);
        return roleRepository.findById(id)
                .map(existingRole -> {
                    BeanUtils.copyProperties(role, existingRole, "id");
                    return roleRepository.save(existingRole);
                })
                .orElseThrow(() -> new NotFoundException("Role with id " + id + " was not found"));
    }

    @Override
    public void deleteRole(Long id) {
        logger.info("Deleting role with id {}", id);
        roleRepository.deleteById(id);
    }
}
