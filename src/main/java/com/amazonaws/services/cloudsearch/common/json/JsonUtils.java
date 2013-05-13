package com.amazonaws.services.cloudsearch.common.json;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Json Utility class.
 *
 * @author Phillip Read
 */
public class JsonUtils {

	/** The Constant jf. */
	private static final JsonFactory jf = new JsonFactory();

	/**
	 * Marshal.
	 *
	 * @param o the o
	 * @return the string
	 * @throws java.io.IOException
	 */
	public static String marshal(Object o) {
		StringWriter sw = new StringWriter();
		try {
			JsonGenerator gen = jf.createJsonGenerator(sw);
			new ObjectMapper().writeValue(gen, o);
			return sw.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Unmarshal.
	 *
	 * @param json the json
	 * @return the object
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object unmarshal(String json, Class clazz) {
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false);
	    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Unmarshal.
	 *
	 * @param json the json
	 * @return the object
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Object unmarshal(String json, TypeReference valueTypeRef) {
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false);
	    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			return mapper.readValue(json, valueTypeRef);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
