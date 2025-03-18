package com.prashant.SpringDataJpaAssignment3.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @ManyToMany(mappedBy = "books")
    private List<Author> author;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String bookName;


}
