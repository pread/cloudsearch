package com.amazonaws.services.cloudsearch.model.sdf;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * This objects represents the add type in an SDF.
 */
public class SearchDocumentAddJson {

    /** The id for the add operation */
    @JsonProperty("type")
    private String type = "add";

    /** The id for the add operation */
    @JsonProperty("id")
    private String id;

    /** The version for the add operation */
    @JsonProperty("version")
    private String version;

    /** The language associated with the add operation */
    @JsonProperty("lang")
    private String lang;

    /** A list of fields to be indexed */
    @JsonProperty("fields")
    private Field fields;

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
        if (obj == null || !(obj instanceof SearchDocumentAddJson)) {return false;}

        final SearchDocumentAddJson that = (SearchDocumentAddJson) obj;
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

