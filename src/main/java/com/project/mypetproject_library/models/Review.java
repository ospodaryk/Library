package com.project.mypetproject_library.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer rating;
    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

}