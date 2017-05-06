package com.cloudskol.jsonbskol.book;

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
        return null;
    }

    public List<Book> all() {
        return null;
    }

    public String add(Book book) {
        return null;
    }

    public void update(String id, Book book) {

    }
}
