package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A Java object representation of a list of search hits from querying the cloud search domain
 *
 * @author Phillip Read
 */
@XmlType(name = "Genre")
@XmlRootElement(name = "genre")
public class Genre {

    /** A list of constraints object representing documents found */
    @XmlElement(name = "constraints")
    @JsonProperty("constraints")
    private List<Constraint> constraints;

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    /**
     * The hashcode representing the Facets object
     *
     * @return the hashcode representing the SearchHits object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(constraints);
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

        final Genre that = (Genre) obj;
        return Objects.equal(this.constraints, that.constraints);
    }

    /**
     * String representation of the SearchHits object
     *
     * @return String representation of the SearchHits object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("constraints", constraints)
                .toString();
    }
}


