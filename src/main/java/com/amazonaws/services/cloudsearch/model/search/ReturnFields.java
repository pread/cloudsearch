/* Copyright (c) 2010 HomeAway, Inc.
 * All rights reserved.  http://homeaway.github.io/thunderhead
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amazonaws.services.cloudsearch.model.search;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * This is the Java object representation of the Results found in querying the cloudsearch domain
 * 
 * @author Phillip Read
 */
@XmlType(name = "ReturnFields")
@XmlRootElement(name = "data")
public class ReturnFields {
    
    /** The name of the result field found */
    @XmlAttribute(name = "actor")
    private List<String> actor;

    @XmlAttribute(name = "director")
    private List<String> director;

    @XmlAttribute(name = "text_relevance")
    @JsonProperty("text_relevance")
    private List<String> textRelevance;

    @XmlAttribute(name = "title")
    private List<String> title;

    @XmlAttribute(name = "year")
    private List<String> year;

    public List<String> getActor() {
        return actor;
    }

    public void setActor(List<String> actor) {
        this.actor = actor;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<String> getTextRelevance() {
        return textRelevance;
    }

    public void setTextRelevance(List<String> textRelevance) {
        this.textRelevance = textRelevance;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getYear() {
        return year;
    }

    public void setYear(List<String> year) {
        this.year = year;
    }

    /**
     * The hashcode representing the ReturnFields object
     *
     * @return the hashcode representing the ReturnFields object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(actor,
                                director, textRelevance,
                                title, year);
    }

    /**
     * Equals method for the ReturnFields object
     *
     * @param obj object to compare if this object is equal to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || !(obj instanceof ReturnFields)) {return false;}

        final ReturnFields that = (ReturnFields) obj;
        return Objects.equal(this.actor, that.actor)
                && Objects.equal(this.director, that.director)
                && Objects.equal(this.textRelevance, that.textRelevance)
                && Objects.equal(this.title, that.title)
                && Objects.equal(this.year, that.year);
    }

    /**
     * String representation of the ReturnFields object
     *
     * @return String representation of the ReturnFields object
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("actor", actor)
                      .add("director", director)
                      .add("textRelevance", textRelevance)
                      .add("title", title)
                      .add("year", year)
                      .toString();
    }
}
