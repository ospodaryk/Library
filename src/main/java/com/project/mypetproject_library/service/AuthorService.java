package com.project.mypetproject_library.service;

import com.project.mypetproject_library.models.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthor(Long id);
    List<Author> getAllAuthors();
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
}
