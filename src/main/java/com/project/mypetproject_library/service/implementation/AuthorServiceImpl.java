package com.project.mypetproject_library.service.implementation;

import com.project.mypetproject_library.exception.NotFoundException;
import com.project.mypetproject_library.models.Author;
import com.project.mypetproject_library.models.User;
import com.project.mypetproject_library.repository.AuthorRepository;
import com.project.mypetproject_library.repository.UserRepository;
import com.project.mypetproject_library.service.AuthorService;
import com.project.mypetproject_library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        logger.info("Creating new author with id {}", author.getId());
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthor(Long id) {
        logger.info("Getting author with id {}", id);
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author with id " + id + " was not found"));
    }

    @Override
    public List<Author> getAllAuthors() {
        logger.info("Getting all authors");
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        logger.info("Updating author with id {}", id);
        return authorRepository.findById(id)
                .map(existingAuthor -> {
                    BeanUtils.copyProperties(author, existingAuthor, "id");
                    return authorRepository.save(existingAuthor);
                })
                .orElseThrow(() -> new NotFoundException("Author with id " + id + " was not found"));
    }

    @Override
    public void deleteAuthor(Long id) {
        logger.info("Deleting author with id {}", id);
        authorRepository.deleteById(id);
    }
}
