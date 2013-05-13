package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This is a Java object representation of a query hit from querying the cloudsearch domain
 */
@XmlType(name = "SearchHit")
@XmlRootElement(name = "hit")
public class SearchHit {

    /** The id for the hit found */
    @XmlAttribute(name = "id")
    private String id;

    /** The list of fields found for this query hit */
    @XmlElement(name = "data")
    @JsonProperty("data")
    private ReturnFields returnFields;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public ReturnFields getReturnFields() {
        return returnFields;
    }

    public void setReturnFields(ReturnFields returnFields) {
        this.returnFields = returnFields;
    }

//    public MultivaluedMap<String, String> getReturnFieldsMap() {
//        return returnFieldsMap;
//    }
//
//    public void setReturnFieldsMap(MultivaluedMap<String, String> returnFieldsMap) {
//        this.returnFieldsMap = returnFieldsMap;
//    }

    /**
     * The hashcode representing the SearchHit object
     *
     * @return the hashcode representing the SearchHit object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id,
                                returnFields);
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
        if (obj == null || !(obj instanceof SearchHit)) {return false;}

        final SearchHit that = (SearchHit) obj;
        return Objects.equal(this.id, that.id)
            && Objects.equal(this.returnFields, that.returnFields);
    }
    
    /**
     * String representation of the SearchHit object
     *
     * @return String representation of the SearchHit object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("id", id)
                      .add("return-fields", returnFields)
                      .toString();
    }
}
