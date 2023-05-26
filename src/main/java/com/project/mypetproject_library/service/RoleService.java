package com.project.mypetproject_library.service;

import com.project.mypetproject_library.models.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRole(Long id);
    List<Role> getAllRoles();
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}
