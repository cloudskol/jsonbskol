package com.cloudskol.jsonbskol.book;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class BooksJsonWriter implements MessageBodyWriter<List<Book>> {
    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return new ArrayList(){}.getClass().getGenericSuperclass() == aClass;
    }

    @Override
    public long getSize(List<Book> books, Class<?> aClass, Type type,
                        Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(List<Book> books, Class<?> aClass, Type type,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        final Jsonb jsonb = JsonbBuilder.create();
        new DataOutputStream(outputStream).writeUTF(jsonb.toJson(books));
    }
}
