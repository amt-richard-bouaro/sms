package com.amalitech.sms.models;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class Book {
    private String title;
    private LocalDate publication_date;
    private String isbn;

    private String genre;

    private Long author_id;

    public Book(String title, LocalDate publication_date, String isbn, String genre, long author_id) {
        this.title = title;
        this.publication_date = publication_date;
        this.isbn = isbn;
        this.genre = genre;
        this.author_id = author_id;
    }

    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(LocalDate publication_date) {
        this.publication_date = publication_date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }
}
