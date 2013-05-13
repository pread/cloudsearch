package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Phillip Read
 */
@XmlType(name = "SearchResponse")
@XmlRootElement(name = "results")
public class SearchResponse {

    /** Facets of the query results */
    @XmlElement(name = "facets")
    private Facets facets;

    /** How to rank the query results */
    @XmlElement(name = "rank")
    private String rank;

    /** What expression was being matched */
    @XmlElement(name = "match-expr")
    @JsonProperty("match-expr")
    private String matchExpr;

    /** The SearchHits object representing the documents found */
    @XmlElement(name = "hits")
    @JsonProperty("hits")
    private SearchHits found;

    /** The SearchInfo object representing some statistics from querying */
    @XmlElement(name = "info")
    private SearchInfo info;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public String getRank() {
        return rank;
    }

    public void setRank(final String rank) {
        this.rank = rank;
    }

    public String getMatchExpr() {
        return matchExpr;
    }

    public void setMatchExpr(final String matchExpr) {
        this.matchExpr = matchExpr;
    }

    public SearchHits getFound() {
        return found;
    }

    public void setFound(final SearchHits found) {
        this.found = found;
    }

    public SearchInfo getInfo() {
        return info;
    }

    public void setInfo(final SearchInfo info) {
        this.info = info;
    }

    public Facets getFacets() {
        return facets;
    }

    public void setFacets(Facets facets) {
        this.facets = facets;
    }

    /**
     * The hashcode representing the SearchResponse object
     *
     * @return the hashcode representing the SearchResponse object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(rank,
                                matchExpr,
                                found,
                                info);
    }

    /**
     * Equals method for the SearchResponse object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof SearchResponse)) {return false;}

        final SearchResponse that = (SearchResponse) obj;
        return Objects.equal(this.rank, that.rank)
            && Objects.equal(this.matchExpr, that.matchExpr)
            && Objects.equal(this.found, that.found)
            && Objects.equal(this.info, that.info);
    }

    /**
     * String representation of the SearchResponse object
     *
     * @return String representation of the SearchResponse object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("rank", rank)
                      .add("match-expr", matchExpr)
                      .add("found", found)
                      .add("info", info)
                      .toString();
    }
}
