package com.project.mypetproject_library.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String biography;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
