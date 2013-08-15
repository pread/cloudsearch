package com.amazonaws.services.cloudsearch.rest;

import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentFormat;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import static com.amazonaws.services.cloudsearch.common.constant.CloudSearchEndpointConstants.*;

/**
 * HTTP REST resource for AWS cloudsearch.
 *
 * @author Phillip Read
 */
@Path(ROOT)
public interface CloudSearchReadResource {

    @GET
    @Path(SEARCH)
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response cloudSearchRead(
            @Context Request request,
            @QueryParam("q") String q,
            @QueryParam("bq") String bq,
            @QueryParam("start") int start,
            @QueryParam("return-fields") String returnFields,
            @QueryParam("facet") String facet);

    @POST
    @Path(BATCH)
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response batch(@Context Request request, SearchDocumentFormat item);

}

