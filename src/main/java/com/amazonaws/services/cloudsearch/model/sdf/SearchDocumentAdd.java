package com.amazonaws.services.cloudsearch.model.sdf;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * This objects represents the add type in an SDF.
 */
@XmlType(name = "Add")
@XmlRootElement(name = "add")
public class SearchDocumentAdd {

    /** The id for the add operation */
    @XmlTransient
    @JsonProperty("type")
    private String type = "add";

    /** The id for the add operation */
    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private String id;

    /** The version for the add operation */
    @XmlAttribute(name = "version")
    @JsonProperty("version")
    private String version;

    /** The language associated with the add operation */
    @XmlAttribute(name = "lang")
    @JsonProperty("lang")
    private String lang;

    /** A list of fields to be indexed */
    @XmlTransient
    @JsonProperty("fields")
    private Field fields;

    /** A list of fields to be indexed */
    @XmlElement(name = "field")
    @JsonIgnore
    private List<FieldElement> fieldElement;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(final String lang) {
        this.lang = lang;
    }

    public Field getFields() {
        return fields;
    }

    public void setFields(Field fields) {
        this.fields = fields;
    }

    public List<FieldElement> getFieldElement() {
        return fieldElement;
    }

    public void setFieldElement(List<FieldElement> fieldElement) {
        this.fieldElement = fieldElement;
    }

    /**
     * The hashcode representing the SearchDocumentAdd object
     *
     * @return The hashcode representing the SearchDocumentAdd object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id,
                                version,
                                lang,
                                fields);
    }

    /**
     * Equals method for the SearchDocumentAdd object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof SearchDocumentAdd)) {return false;}

        final SearchDocumentAdd that = (SearchDocumentAdd) obj;
        return Objects.equal(this.id, that.id)
            && Objects.equal(this.version, that.version)
            && Objects.equal(this.lang, that.lang)
            && Objects.equal(this.fields, that.fields);

    }

    /**
     * String representation of the SearchDocumentAdd object
     *
     * @return String representation of the SearchDocumentAdd object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("id", id)
                      .add("version", version)
                      .add("lang", lang)
                      .add("fields", fields)
                      .toString();
    }
}
