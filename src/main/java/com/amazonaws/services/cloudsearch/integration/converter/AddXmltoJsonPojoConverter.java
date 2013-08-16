package com.amazonaws.services.cloudsearch.integration.converter;

import com.amazonaws.services.cloudsearch.model.sdf.Field;
import com.amazonaws.services.cloudsearch.model.sdf.FieldElement;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAdd;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAddJson;
import org.apache.camel.Converter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Converter
public class AddXmltoJsonPojoConverter {

    @Converter
    public static SearchDocumentAddJson toJsonPojo(SearchDocumentAdd xmlPojo) {

        SearchDocumentAddJson target = new SearchDocumentAddJson();
        Field jsonType = new Field();
        List<String> genre = new ArrayList<String>();
        List<String> actor = new ArrayList<String>();

        for(FieldElement xmlType : xmlPojo.getFieldElement()) {
            String name = xmlType.getName();
            if (StringUtils.equals(name, "title")) {
                jsonType.setTitle(xmlType.getValue());
            } else if (StringUtils.equals(name, "director")) {
                jsonType.setDirector(xmlType.getValue());
            } else if (StringUtils.equals(name, "year")) {
                jsonType.setYear(Integer.valueOf(xmlType.getValue()));
            } else if (StringUtils.equals(name, "genre")) {
                genre.add(xmlType.getValue());
            } else if (StringUtils.equals(name, "actor")) {
                actor.add(xmlType.getValue());
            }
        }
        jsonType.setActor(actor);
        jsonType.setGenre(genre);
        target.setId(xmlPojo.getId());
        target.setType(xmlPojo.getType());
        target.setVersion(xmlPojo.getVersion());
        target.setLang(xmlPojo.getLang());
        target.setFields(jsonType);
        return target;
    }
}
