package com.amazonaws.services.cloudsearch.common.exception;

public class ErrorRepresentation {

    private Integer errorCode;

    private String message;

    public ErrorRepresentation() {
    }

    public ErrorRepresentation(Integer httpErrorCode, String message) {
        this.errorCode = httpErrorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
