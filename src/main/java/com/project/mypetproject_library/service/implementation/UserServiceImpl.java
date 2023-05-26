package com.project.mypetproject_library.service.implementation;

import com.project.mypetproject_library.exception.NotFoundException;
import com.project.mypetproject_library.models.User;
import com.project.mypetproject_library.repository.UserRepository;
import com.project.mypetproject_library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        logger.info("Creating new user with id {}", user.getId());
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        logger.info("Getting user with id {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " was not found"));
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        logger.info("Updating user with id {}", id);
        return userRepository.findById(id)
                .map(existingUser -> {
                    BeanUtils.copyProperties(user, existingUser, "id");
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new NotFoundException("User with id " + id + " was not found"));
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("Deleting user with id {}", id);
        userRepository.deleteById(id);
    }
}
