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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This is a Java object representation of a query hit from querying the cloudsearch domain
 * 
 * @author jmonette
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

//    /** A map for easy look up of the returnFieldsList(not map via xml, built on the fly) */
//    @XmlTransient
//    private MultivaluedMap<String, String> returnFieldsMap;

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
