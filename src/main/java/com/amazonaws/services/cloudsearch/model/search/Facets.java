package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A Java object representation of a list of search hits from querying the cloud search domain
 *
 * @author Phillip Read
 */
@XmlType(name = "Facets")
@XmlRootElement(name = "facets")
public class Facets {

    /** A list of Facets object representing documents found */
    @XmlElement(name = "genre")
    @JsonProperty("genre")
    private Genre genre;

    /**
     * The hashcode representing the Facets object
     *
     * @return the hashcode representing the SearchHits object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(genre);
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
        if (obj == null || !(obj instanceof Genre)) {return false;}

        final Facets that = (Facets) obj;
        return Objects.equal(this.genre, that.genre);
    }

    /**
     * String representation of the SearchHits object
     *
     * @return String representation of the SearchHits object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("genre", genre)
                .toString();
    }
}

