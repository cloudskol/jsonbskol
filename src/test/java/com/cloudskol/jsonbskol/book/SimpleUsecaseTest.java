package com.cloudskol.jsonbskol.book;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author tham
 */

public class SimpleUsecaseTest {
    @Test
    public void testSimple() {
        final Book book = new Book("1591843170",
                "Purple Cow, New Edition: Transform Your Business by Being Remarkable",
                "Seth Godin",
                LocalDate.of(2009, 11, 12));


        final Jsonb jsonb = JsonbBuilder.create();
        final String bookJson = jsonb.toJson(book);
        System.out.println(bookJson);

        final Book deserializedBook = jsonb.fromJson(bookJson, Book.class);
        System.out.println(deserializedBook.toString());
    }

    @Test
    public void testWithConfig() {
        final Book book = new Book("1591843170",
                "Purple Cow, New Edition: Transform Your Business by Being Remarkable",
                "Seth Godin",
                LocalDate.of(2009, 11, 12));

        final JsonbConfig jsonbConfig = new JsonbConfig()
                .withFormatting(true)
                .withDateFormat("yyyy-MMM-dd", Locale.getDefault());

        final Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        final String bookJson = jsonb.toJson(book);
        System.out.println(bookJson);
    }

    @Test
    public void testMultiple() {
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

        final Book book3 = new Book("0670921602",
                "The Lean Startup: How Constant Innovation Creates Radically Successful Businesses",
                "Peter Thiel",
                LocalDate.of(2011, 10, 6));
        books.add(book3);

        final Jsonb jsonb = JsonbBuilder.create();
        final String booksJson = jsonb.toJson(books);
        System.out.println(booksJson);

        final List<Book> booksList = jsonb.fromJson(booksJson,
                new ArrayList<Book>(){}.getClass().getGenericSuperclass());
        System.out.println(booksList);
    }
}
