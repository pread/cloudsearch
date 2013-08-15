package com.amazonaws.services.cloudsearch.model.sdf;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * This object representation the fields to be indexed in the SDF
 */
public class Field {

    /** The name of the field found */
    @JsonProperty("title")
    private String title;

    /** The name of the field found */
    @JsonProperty("director")
    private String director;

    @JsonProperty("year")
    private Integer year;

    /** The name of the field found */
    @JsonProperty("genre")
    private List<String> genre;

    /** The name of the field found */
    @JsonProperty("actor")
    private List<String> actor;

    /****************************** */
    /*    Getters and Setters       */
    /****************************** */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getActor() {
        return actor;
    }

    public void setActor(List<String> actor) {
        this.actor = actor;
    }

    /**
     * The hashcode representing the Field object
     * 
     * @return the hashcode representing the Field object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(title,
                                director,
                                year);
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

        final Field that = (Field) obj;
        return Objects.equal(this.title, that.title)
                && Objects.equal(this.director, that.director)
                && Objects.equal(this.year, that.year);
    }

    /**
     * String representation of the Field object
     * 
     * @return String representation of the Field object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("title", title)
                      .add("director", director)
                      .add("year", year)
                      .toString();
    }
}
