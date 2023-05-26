package com.project.mypetproject_library.service.implementation;
import com.project.mypetproject_library.exception.NotFoundException;
import com.project.mypetproject_library.models.BookList;
import com.project.mypetproject_library.models.Review;
import com.project.mypetproject_library.repository.BookListRepository;
import com.project.mypetproject_library.repository.ReviewRepository;
import com.project.mypetproject_library.service.BookListService;
import com.project.mypetproject_library.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.project.mypetproject_library.exception.NullEntityReferenceException;
import com.project.mypetproject_library.models.Role;
import com.project.mypetproject_library.repository.RoleRepository;
import com.project.mypetproject_library.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookListServiceImpl implements BookListService {
    private final BookListRepository bookListRepository;
    private final Logger logger = LoggerFactory.getLogger(BookListServiceImpl.class);

    public BookListServiceImpl(BookListRepository bookListRepository) {
        this.bookListRepository = bookListRepository;
    }

    @Override
    public BookList createBookList(BookList bookList) {
        logger.info("Creating new book list with id {}", bookList.getId());
        return bookListRepository.save(bookList);
    }

    @Override
    public BookList getBookList(Long id) {
        logger.info("Getting book list with id {}", id);
        return bookListRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BookList with id " + id + " was not found"));
    }

    @Override
    public List<BookList> getAllBookLists() {
        logger.info("Getting all book lists");
        return bookListRepository.findAll();
    }

    @Override
    public BookList updateBookList(Long id, BookList bookList) {
        logger.info("Updating book list with id {}", id);
        return bookListRepository.findById(id)
                .map(existingBookList -> {
                    BeanUtils.copyProperties(bookList, existingBookList, "id");
                    return bookListRepository.save(existingBookList);
                })
                .orElseThrow(() -> new NotFoundException("BookList with id " + id + " was not found"));
    }

    @Override
    public void deleteBookList(Long id) {
        logger.info("Deleting book list with id {}", id);
        bookListRepository.deleteById(id);
    }
}
