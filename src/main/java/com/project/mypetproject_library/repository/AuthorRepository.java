package com.project.mypetproject_library.repository;

import com.project.mypetproject_library.models.Author;
import com.project.mypetproject_library.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
