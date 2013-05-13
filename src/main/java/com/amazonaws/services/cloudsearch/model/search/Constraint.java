package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This is a Java object representation of a query hit from querying the cloudsearch domain
 *
 * @author Phillip Read
 */
@XmlType(name = "Constraint")
@XmlRootElement(name = "constraint")
public class Constraint {

    /** The constraint count */
    @XmlAttribute(name = "count")
    private int count;

    /** The constraint value */
    @XmlAttribute(name = "value")
    private String value;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * The hashcode representing the SearchHit object
     *
     * @return the hashcode representing the SearchHit object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(count, value);
    }

    /**
     * Equals method for the SearchHit object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof Constraint)) {return false;}

        final Constraint that = (Constraint) obj;
        return Objects.equal(this.count, that.count)
                && Objects.equal(this.value, that.value);
    }

    /**
     * String representation of the SearchHit object
     *
     * @return String representation of the SearchHit object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("count", count)
                .add("value", value)
                .toString();
    }

}

