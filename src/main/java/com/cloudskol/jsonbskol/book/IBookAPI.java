package com.cloudskol.jsonbskol.book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tham
 */
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public interface IBookAPI {

    @GET
    @Path("{id}")
    Response get(@PathParam("id") String id);

    @GET
    Response all();
}
