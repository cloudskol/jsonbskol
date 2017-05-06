package com.cloudskol.jsonbskol.book;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author tham
 */

public class BookAPI implements IBookAPI {
    @Override
    public Response get(String id) {
        final Book book = BookManager.getInstance().get(id);
        return Response.ok(book).build();
    }

    @Override
    public Response all() {
        final List<Book> books = BookManager.getInstance().all();
//        return Response.ok(new GenericEntity<List<Book>>(books){}).build();
        return Response.ok(books).build();
    }
}
