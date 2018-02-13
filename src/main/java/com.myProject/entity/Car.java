package com.myProject.entity;

package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;

@Entity(name = "Car")
@Table(name = "car") // case sensitive!
public class Car {
    private String title;

    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_year")
    private int publicationYear;

    public car() {
    }

    public car(String title, Author author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

}

