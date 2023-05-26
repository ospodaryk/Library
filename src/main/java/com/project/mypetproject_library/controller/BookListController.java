package com.project.mypetproject_library.controller;
import com.project.mypetproject_library.models.Role;
import com.project.mypetproject_library.models.BookList;
import com.project.mypetproject_library.service.BookListService;
import com.project.mypetproject_library.service.RoleService;
import com.project.mypetproject_library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booklists")
public class BookListController {
    private final BookListService bookListService;

    public BookListController(BookListService bookListService) {
        this.bookListService = bookListService;
    }

    @PostMapping
    public ResponseEntity<BookList> createBookList(@RequestBody BookList bookList) {
        return ResponseEntity.ok(bookListService.createBookList(bookList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookList> getBookList(@PathVariable Long id) {
        return ResponseEntity.ok(bookListService.getBookList(id));
    }

    @GetMapping
    public ResponseEntity<List<BookList>> getAllBookLists() {
        return ResponseEntity.ok(bookListService.getAllBookLists());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookList> updateBookList(@PathVariable Long id, @RequestBody BookList bookList) {
        return ResponseEntity.ok(bookListService.updateBookList(id, bookList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookList(@PathVariable Long id) {
        bookListService.deleteBookList(id);
        return ResponseEntity.noContent().build();
    }
}
