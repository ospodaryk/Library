package com.project.mypetproject_library.repository;


import com.project.mypetproject_library.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
