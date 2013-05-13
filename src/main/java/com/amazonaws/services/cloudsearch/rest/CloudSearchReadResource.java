package com.amazonaws.services.cloudsearch.rest;

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
            @QueryParam("return-fields") String returnFields,
            @QueryParam("facet") String facet);

}

