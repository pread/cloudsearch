package com.amazonaws.services.cloudsearch.model.sdf;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.*;

/**
 * This object representation the fields to be indexed in the SDF
 */
@XmlType(name = "Field")
@XmlRootElement(name = "field")
public class FieldElement {

    /** The name of the field found */
    @XmlAttribute(name = "name")
    private String name;

    @XmlValue
    private String value;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * The hashcode representing the Field object
     *
     * @return the hashcode representing the Field object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /**
     * Equals method for the Field object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof FieldElement)) {return false;}

        final FieldElement that = (FieldElement) obj;
        return Objects.equal(this.name, that.name);
    }

    /**
     * String representation of the Field object
     *
     * @return String representation of the Field object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}

