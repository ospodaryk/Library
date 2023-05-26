package com.project.mypetproject_library.repository;

import com.project.mypetproject_library.models.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepository extends JpaRepository<BookList, Long> {
}
