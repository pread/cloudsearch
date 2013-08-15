package com.amazonaws.services.cloudsearch.model.sdf;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This object representation the fields to be indexed in the SDF
 */
@XmlType(name = "Message")
@XmlRootElement(name = "Message")
public class Message {

    /** The name of the field found */
    @XmlAttribute(name = "message")
    @JsonProperty("message")
    private String message;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * The hashcode representing the Field object
     *
     * @return the hashcode representing the Field object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(message);
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
        if (obj == null || !(obj instanceof Field)) {return false;}

        final Message that = (Message) obj;
        return Objects.equal(this.message, that.message);
    }

    /**
     * String representation of the Field object
     *
     * @return String representation of the Field object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("message", message)
                .toString();
    }
}

