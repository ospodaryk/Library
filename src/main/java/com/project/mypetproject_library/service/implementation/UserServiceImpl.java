package com.project.mypetproject_library.service.implementation;

import com.project.mypetproject_library.models.User;
import com.project.mypetproject_library.repository.UserRepository;
import com.project.mypetproject_library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        logger.info("Retrieving all users from the database");
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        logger.info("Retrieving user with id {} from the database", id);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found for id : " + id);
        }
    }

    public User createUser(User user) {
        logger.info("Creating a new user in the database");
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        logger.info("Updating user with id {} in the database", id);
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User u = existingUser.get();
            u.setLogin(user.getLogin());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());
            userRepository.save(u);
            return u;
        } else {
            throw new RuntimeException("User not found for id : " + id);
        }
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user with id {} from the database", id);
        userRepository.deleteById(id);
    }
}
