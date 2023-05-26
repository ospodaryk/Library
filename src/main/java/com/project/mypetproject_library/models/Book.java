package com.project.mypetproject_library.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    private Integer publicationYear;
    private String description;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

}
