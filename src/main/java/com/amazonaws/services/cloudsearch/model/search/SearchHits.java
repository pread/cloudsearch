package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A Java object representation of a list of search hits from querying the cloud search domain
 * 
 * @author Phillip Read
 */
@XmlType(name = "SearchHits")
@XmlRootElement(name = "hits")
public class SearchHits {

    /** The number of documents found */
    @XmlAttribute(name = "found")
    @JsonProperty("found")
    private int count;

    /** The starting index */
    @XmlAttribute(name = "start")
    private int start;

    /** A list of SearchHit object representing documents found */
    @XmlElement(name = "hit")
    @JsonProperty("hit")
    private List<SearchHit> hits;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(final int start) {
        this.start = start;
    }

    public List<SearchHit> getHits() {
        return hits;
    }

    public void setHits(final List<SearchHit> hits) {
        this.hits = hits;
    }

    /**
     * The hashcode representing the SearchHits object
     *
     * @return the hashcode representing the SearchHits object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(count,
                                start,
                                hits);
    }

    /**
     * Equals method for the SearchHits object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof SearchHits)) {return false;}

        final SearchHits that = (SearchHits) obj;
        return Objects.equal(this.count, that.count)
            && Objects.equal(this.start, that.start)
            && Objects.equal(this.hits, that.hits);
    }

    /**
     * String representation of the SearchHits object
     *
     * @return String representation of the SearchHits object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("count", count)
                      .add("start", start)
                      .add("hits", hits)
                      .toString();
    }
}
