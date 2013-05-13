package com.amazonaws.services.cloudsearch.service;

import com.amazonaws.services.cloudsearch.model.search.SearchResponse;

/**
 * HTTP REST client for consuming AWS Cloud Search services.
 *
 * @author Phillip Read
 */
public interface CloudSearchService {

    SearchResponse cloudSearchRead(String q, String returnFields, String facet);

}
