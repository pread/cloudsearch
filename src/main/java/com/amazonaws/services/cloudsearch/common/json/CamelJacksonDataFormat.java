package com.amazonaws.services.cloudsearch.common.json;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class CamelJacksonDataFormat extends JacksonDataFormat {

   public CamelJacksonDataFormat() {
       this.getObjectMapper().configure(SerializationConfig.Feature.INDENT_OUTPUT, false);
       this.getObjectMapper()
               .setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS)
               .enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT) ;
       this.getObjectMapper().configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false);
       this.getObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);
       this.getObjectMapper().configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
   }

}
