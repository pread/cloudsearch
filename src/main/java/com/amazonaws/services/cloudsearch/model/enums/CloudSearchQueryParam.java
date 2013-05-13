package com.amazonaws.services.cloudsearch.model.enums;

import com.google.common.base.Objects;

/**
 * This class defines constants for the query params used in cloudsearch
 *
 * @author jmonette
 */
public enum CloudSearchQueryParam {

    BQ("bq"),
    FACET("facet"),
    Q("q"),
    RANK("rank"),
    RESULTS_TYPE("results-type"),
    RETURN_FIELDS("return-fields"),
    SIZE("size"),
    START("start");

    private String queryParam;
    private CloudSearchQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getName() {
        return this.queryParam;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("queryParam", this.queryParam)
                .toString();

    }

}
