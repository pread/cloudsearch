package com.amazonaws.services.cloudsearch.service;


import static com.amazonaws.services.cloudsearch.model.enums.CloudSearchQueryParam.*;
import static com.amazonaws.services.cloudsearch.common.constant.CloudSearchEndpointConstants.*;
import com.amazonaws.services.cloudsearch.model.search.SearchResponse;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.cloudsearch.common.exception.ErrorRepresentation;
import com.amazonaws.services.cloudsearch.rest.CloudSearchReadResource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.OK;
import java.util.Date;

/**
 * HTTP REST client for consuming AWS Cloud Search services.
 *
 * @author Phillip Read
 */
@Service("cloudSearchService")
public class CloudSearchServiceImpl implements CloudSearchService {

    /** The Proxy AWS cloud Search. */
    @Autowired(required = true)
    private CloudSearchReadResource proxyCloudSearchRead;

    public SearchResponse cloudSearchRead(String q, String returnFields, String facet) {

        Date today = new Date();

        Client client = WebClient.client(proxyCloudSearchRead)
                .type("application/json")
                .accept("application/json")
                .modified(today, false);

        WebClient wc = WebClient.fromClient(client, true);

        ClientConfiguration cc = WebClient.getConfig(wc);
        cc.getInFaultInterceptors().add(new LoggingInInterceptor());
        cc.getInInterceptors().add(new LoggingInInterceptor());
        cc.getOutInterceptors().add(new LoggingOutInterceptor());

        SearchResponse result = wc.path(ROOT + SEARCH)
                .query(Q.getName(), q)
                .query(RETURN_FIELDS.getName(), returnFields)
                .query(FACET.getName(), facet).get(SearchResponse.class);

        Response response = wc.getResponse();
        int status = (response == null) ? Response.Status.NO_CONTENT.getStatusCode() : response.getStatus();

        if (Response.Status.NO_CONTENT.getStatusCode() == status) {
            return null;
        }

        if (OK.getStatusCode() != status) {
            throw new WebApplicationException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorRepresentation(status, "Hard Request!"))
                    .build());
        }

        return result;
    }

}
