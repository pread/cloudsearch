package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SearchInfo")
@XmlRootElement(name = "info")
public class SearchInfo {
    
    /** */
    @XmlAttribute(name = "rid")
    private String rid;

    /** The time in milliseconds to query the cloudsearch domain */
    @XmlAttribute(name = "time-ms")
    @JsonProperty("time-ms")
    private String timeMs;

    /** The actual cpu time in milliseconds to query the cloudsearch domain */
    @XmlAttribute(name = "cpu-time-ms")
    @JsonProperty("cpu-time-ms")
    private String cpuTimeMs;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public String getRid() {
        return rid;
    }

    public void setRid(final String rid) {
        this.rid = rid;
    }

    public String getTimeMs() {
        return timeMs;
    }

    public void setTimeMs(final String timeMs) {
        this.timeMs = timeMs;
    }

    public String getCpuTimeMs() {
        return cpuTimeMs;
    }

    public void setCpuTimeMs(final String cpuTimeMs) {
        this.cpuTimeMs = cpuTimeMs;
    }

    /**
     * The hashcode representing the SearchInfo object
     *
     * @return the hashcode representing the SearchInfo object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(rid,
                                timeMs,
                                cpuTimeMs);
    }
    
    /**
     * Equals method for the SearchInfo object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof SearchInfo)) {return false;}

        final SearchInfo that = (SearchInfo) obj;
        return Objects.equal(this.rid, that.rid)
            && Objects.equal(this.timeMs, that.timeMs)
            && Objects.equal(this.cpuTimeMs, that.cpuTimeMs);
    }

    /**
     * String representation of the SearchInfo object
     *
     * @return String representation of the SearchInfo object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("rid", rid)
                      .add("time-ms", timeMs)
                      .add("cpu-time-ms", cpuTimeMs)
                      .toString();
    }
}
