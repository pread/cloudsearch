package com.amazonaws.services.cloudsearch.model.sdf;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The Java object representation of the SDF document to upload to Amazon cloudsearch
 */
@XmlType(name = "Batch")
@XmlRootElement(name = "batch")
public class SearchDocumentFormat {

    /** A batch of SDF adds to POST to Amazon */
    @XmlElement(name = "add")
    private List<SearchDocumentAdd> searchDocumentAdds;

    /** A batch of SDF deletes to POST to Amazon */
    @XmlElement(name = "delete")
    private List<SearchDocumentDelete> searchDocumentDeletes;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public List<SearchDocumentAdd> getSearchDocumentAdds() {
        return searchDocumentAdds;
    }

    public void setSearchDocumentAdds(final List<SearchDocumentAdd> searchDocumentAdds) {
        this.searchDocumentAdds = searchDocumentAdds;
    }

    public List<SearchDocumentDelete> getSearchDocumentDeletes() {
        return searchDocumentDeletes;
    }

    public void setSearchDocumentDeletes(final List<SearchDocumentDelete> searchDocumentDeletes) {
        this.searchDocumentDeletes = searchDocumentDeletes;
    }

    /**
     * The hashcode representing the SearchDocumentFormat object
     *
     * @return The hashcode representing the SearchDocumentFormat object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(searchDocumentAdds,
                                searchDocumentDeletes);
    }

    /**
     * Equals method for the SearchDocumentFormat object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof SearchDocumentFormat)) {return false;}

        final SearchDocumentFormat that = (SearchDocumentFormat) obj;
        return Objects.equal(this.searchDocumentAdds, that.searchDocumentAdds)
            && Objects.equal(this.searchDocumentDeletes, that.searchDocumentDeletes);

    }

    /**
     * String representation of the SearchDocumentFormat object
     *
     * @return String representation of the SearchDocumentFormat object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("adds", searchDocumentAdds)
                      .add("deletes", searchDocumentDeletes)
                      .toString();
    }
}
