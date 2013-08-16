package com.amazonaws.services.cloudsearch.route;

import com.amazonaws.services.cloudsearch.integration.aggregation.SdfAggregationStrategy;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAdd;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAddJson;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import static org.apache.camel.language.tokenizer.TokenizeLanguage.tokenizeXML;

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
                .split(tokenizeXML("add", "batch"), new SdfAggregationStrategy()).streaming()
                   .unmarshal().jaxb("com.amazonaws.services.cloudsearch.model.sdf")
                   .transform(body(SearchDocumentAdd.class).convertTo(SearchDocumentAddJson.class))
                .end()
                .to("bean:cloudSearchService?method=batch")
                .marshal().json(JsonLibrary.Jackson)
                .to("stream:out")
                //.to("activemq:queue:order")
                .log("<------- Exiting Camel Route for processing SDF file");
    }

}
