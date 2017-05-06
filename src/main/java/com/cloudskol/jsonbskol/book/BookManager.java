package com.cloudskol.jsonbskol.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 */

public class BookManager {
    private static final BookManager instance = new BookManager();
    private BookManager() {}

    public static final synchronized BookManager getInstance() {
        return instance;
    }

    public Book get(String id) {
        return new Book("1591843170",
                "Purple Cow, New Edition: Transform Your Business by Being Remarkable",
                "Seth Godin",
                LocalDate.of(2009, 11, 12));
    }

    public List<Book> all() {
        List<Book> books = new ArrayList<Book>(4);

        final Book book = new Book("1591843170",
                "Purple Cow, New Edition: Transform Your Business by Being Remarkable",
                "Seth Godin",
                LocalDate.of(2009, 11, 12));
        books.add(book);

        final Book book1 = new Book("023076651X",
                "The $100 Startup: Fire your Boss, Do what you Love and Work Better to Live More",
                "Chris Guillebeau",
                LocalDate.of(2012, 5, 24));
        books.add(book1);

        final Book book2 = new Book("0753555190",
                "Zero to One: Note on Start Ups, or How to Build the Future",
                "Peter Thiel",
                LocalDate.of(2014, 9, 18));
        books.add(book2);

        return books;
    }
}
