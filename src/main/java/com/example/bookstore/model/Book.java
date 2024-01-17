package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    private Integer id;
    private String title;
    private Author author;
    private Category category;
    private Integer year;
    private String language;
}
