package com.amazonaws.services.cloudsearch.common.json;

import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.text.SimpleDateFormat;

/**
 * Json Object Mapper with configuration options set.
 * 
 * @author Phillip Read
 */
public class JsonObjectMapper extends ObjectMapper {
	
	private static final SimpleDateFormat TIA_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	/**
	 * Instantiates a new json object mapper.
	 */
	public JsonObjectMapper() {
		super();
        this.getJsonFactory().setCharacterEscapes(new SMRCharacterEscapes());
	    this.configure(SerializationConfig.Feature.INDENT_OUTPUT, false);	    
	    this.setDateFormat(TIA_DATE_TIME_FORMAT);
        this.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);
        this.enableDefaultTyping(DefaultTyping.JAVA_LANG_OBJECT);
        this.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false);
        this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        this.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
	}

    // First, definition of what to escape
    public class SMRCharacterEscapes extends CharacterEscapes
    {
        private final int[] asciiEscapes;

        public SMRCharacterEscapes()
        {
            // start with set of characters known to require escaping (double-quote, backslash etc)
            int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
            // and force escaping of a few others:
            esc['<'] = CharacterEscapes.ESCAPE_STANDARD;
            esc['>'] = CharacterEscapes.ESCAPE_STANDARD;
            esc['&'] = CharacterEscapes.ESCAPE_STANDARD;
            esc['\''] = CharacterEscapes.ESCAPE_STANDARD;
            asciiEscapes = esc;
        }
        // this method gets called for character codes 0 - 127
        @Override public int[] getEscapeCodesForAscii() {
            return asciiEscapes;
        }
        // and this for others; we don't need anything special here
        @Override public SerializableString getEscapeSequence(int ch) {
            // no further escaping (beyond ASCII chars) needed:
            return null;
        }
    }

}
