package com.amazonaws.services.cloudsearch.model.upload;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The Java object representation of the response return from Amazon cloudsearch when updating the domain
 */
@XmlType(name = "Response")
@XmlRootElement(name = "response")
public class UploadResponse {

    /** The status of update */
    @XmlAttribute(name = "status")
    private String status;

    /** The number of adds POSTed to the cloudsearch domain */
    @XmlAttribute(name = "adds")
    private int adds;

    /** The number of deletes POSTed to the cloudsearch domain */
    @XmlAttribute(name = "deletes")
    private int deletes;

    /** Any errors encountered in POSTing to the cloudsearch domain */
    @XmlElementWrapper(name = "errors")
    @XmlElement(name = "error")
    private List<String> errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public int getAdds() {
        return adds;
    }

    public void setAdds(final int adds) {
        this.adds = adds;
    }

    public int getDeletes() {
        return deletes;
    }

    public void setDeletes(final int deletes) {
        this.deletes = deletes;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }

    /**
     * The hashcode representing the UploadResponse object
     *
     * @return the hashcode representing the UploadResponse object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(errors,
                                status,
                                adds,
                                deletes);
    }

    /**
     * Equals method for the UploadResponse object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof UploadResponse)) {return false;}

        final UploadResponse that = (UploadResponse) obj;
        return Objects.equal(this.errors, that.errors)
            && Objects.equal(this.status, that.status)
            && Objects.equal(this.adds, that.adds)
            && Objects.equal(this.deletes, that.deletes);
    }

    /**
     * String representation of the UploadResponse object
     *
     * @return String representation of the UploadResponse object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("status", status)
                      .add("adds", adds)
                      .add("deletes", deletes)
                      .add("errors", errors)
                      .toString();
    }
}
