package com.amazonaws.services.cloudsearch.service;

import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentFormat;
import com.amazonaws.services.cloudsearch.model.search.SearchResponse;
import com.amazonaws.services.cloudsearch.model.upload.UploadResponse;

/**
 * HTTP REST client for consuming AWS Cloud Search services.
 *
 * @author Phillip Read
 */
public interface CloudSearchService {

    SearchResponse cloudSearchRead(String q, String returnFields, int start, String facet);
    SearchResponse cloudSearchBooleanQuery(String bq, String returnFields, int start, String facet);
    UploadResponse batch(SearchDocumentFormat item);
}
