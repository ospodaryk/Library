package com.project.mypetproject_library.service.implementation;

import com.project.mypetproject_library.exception.NotFoundException;
import com.project.mypetproject_library.repository.BookRepository;
import com.project.mypetproject_library.service.BookService;

import com.project.mypetproject_library.models.Book;
import com.project.mypetproject_library.exception.NullEntityReferenceException;
import com.project.mypetproject_library.models.Role;
import com.project.mypetproject_library.repository.RoleRepository;
import com.project.mypetproject_library.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        logger.info("Creating new book with id {}", book.getId());
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        logger.info("Getting book with id {}", id);
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " was not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        logger.info("Updating book with id {}", id);
        return bookRepository.findById(id)
                .map(existingBook -> {
                    BeanUtils.copyProperties(book, existingBook, "id");
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " was not found"));
    }

    @Override
    public void deleteBook(Long id) {
        logger.info("Deleting book with id {}", id);
        bookRepository.deleteById(id);
    }
}
