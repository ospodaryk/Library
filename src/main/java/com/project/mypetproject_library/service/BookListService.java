package com.project.mypetproject_library.service;

import com.project.mypetproject_library.models.BookList;

import java.util.List;

public interface BookListService {
    BookList createBookList(BookList bookList);
    BookList getBookList(Long id);
    List<BookList> getAllBookLists();
    BookList updateBookList(Long id, BookList bookList);
    void deleteBookList(Long id);
}
