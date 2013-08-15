package com.amazonaws.services.cloudsearch.route;

import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAdd;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAddJson;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

/**
 * Camel Router for Reference Data.
 *
 * @author Phillip Read
 */
@Component
public class MovieSDFRouter extends RouteBuilder {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	public void configure() {

        from("file:data/inbox?noop=true")
                .log("Entering Camel Route for processing SDF file ------->")
                .split().tokenizeXML("add", "batch").streaming()
                .unmarshal().jaxb("com.amazonaws.services.cloudsearch.model.sdf")
                .transform(body(SearchDocumentAdd.class).convertTo(SearchDocumentAddJson.class))
                .marshal().json(JsonLibrary.Jackson)
                .to("stream:out")
                //.to("activemq:queue:order")
                .log("<------- Exiting Camel Route for processing SDF file");
    }

}
