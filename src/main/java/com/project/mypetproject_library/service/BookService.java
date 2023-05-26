package com.project.mypetproject_library.service;

import com.project.mypetproject_library.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBook(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}
