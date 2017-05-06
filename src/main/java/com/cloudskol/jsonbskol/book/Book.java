package com.cloudskol.jsonbskol.book;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author tham
 */

public class Book {
    private String id;
    private String isbn;
    private String title;
    private String[] authors;
    private LocalDate date;

    public Book() {}

    public Book(String isbn, String title, String author, LocalDate date) {
        this(isbn, title, new String[] {author}, date);
    }

    public Book(String isbn, String title, String[] authors, LocalDate date) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", date=" + date +
                '}';
    }
}
