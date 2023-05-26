package com.project.mypetproject_library.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class BookList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToMany
    private List<Book> books;

    @ManyToOne
    private User user;

}