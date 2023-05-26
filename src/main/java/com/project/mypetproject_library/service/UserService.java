package com.project.mypetproject_library.service;

import com.project.mypetproject_library.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
