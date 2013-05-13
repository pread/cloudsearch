package com.amazonaws.services.cloudsearch.common.validation;

/**
 * Pass back list validation errors to browser.
 * Result of validating client request.
 *
 * @author Phillip Read
 *
 */
public class Violation {

    private String field;

    private String message;

    public Violation(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
