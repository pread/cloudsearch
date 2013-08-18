package com.amazonaws.services.cloudsearch.mediation.aggregation;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAddJson;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class SdfAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        List<SearchDocumentAddJson> sdfAddPojo;
        if (oldExchange == null) {
            sdfAddPojo = new ArrayList<SearchDocumentAddJson>();
        } else {
            sdfAddPojo = (List<SearchDocumentAddJson>) oldExchange.getIn().getBody();
        }
        sdfAddPojo.add(newExchange.getIn().getBody(SearchDocumentAddJson.class));
        newExchange.getIn().setBody(sdfAddPojo);
        return newExchange;
    }

}