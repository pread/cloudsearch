package com.amazonaws.services.cloudsearch.common.json;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;

/**
 * JaxbJacksonObjectMapper.java: This is the custom JAXB JSON ObjectMapper
 * <p>
 * I modified a little bit to use the latest {@link org.codehaus.jackson.map.DeserializationConfig} API
 * instead of deprecated ones.
 * <p> *
 * @author Phillip Read
 */
public class JaxbJacksonObjectMapper extends ObjectMapper {

	/**
	 * Annotation introspector to use for serialization process
	 * is configured separately for serialization and deserialization purposes
	 */
	public JaxbJacksonObjectMapper() {

		  final AnnotationIntrospector introspector
		      = new JacksonAnnotationIntrospector();
		  super.getDeserializationConfig()
		       .withAnnotationIntrospector(introspector);
		  super.getSerializationConfig()
		       .withAnnotationIntrospector(introspector);

		  //this.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false);
		  this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  this.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
	}
}
