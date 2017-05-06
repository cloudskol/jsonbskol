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

/**
 * @author tham
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class BookJsonWriter implements MessageBodyWriter<Book> {
    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return Book.class == aClass;
    }

    @Override
    public long getSize(Book book, Class<?> aClass, Type type,
                        Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(Book book, Class<?> aClass, Type type,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        final Jsonb jsonb = JsonbBuilder.create();
        new DataOutputStream(outputStream).writeUTF(jsonb.toJson(book));
    }
}
