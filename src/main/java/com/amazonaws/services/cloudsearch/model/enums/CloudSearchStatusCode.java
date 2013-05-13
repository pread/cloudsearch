package com.amazonaws.services.cloudsearch.model.enums;

import com.google.common.base.Objects;

/**
 * Possible status codes used in cloudsearch
 *
 * @author jmonette
 */
public enum CloudSearchStatusCode {
    BAD_REQUEST(400, 400, "Bad Request"),
    LENGTH_REQUIRED(401, 411, "Content-Length Required"),
    FORBIDDEN(403, 403, "Forbidden"),
    NOT_FOUND(404, 404, "Not Found"),
    METHOD_NOT_ALLOWED(405, 405, "Http Method Not Allowed"),
    NOT_ACCEPTABLE(406, 406, "Invalid Accept Header"),
    REQUEST_TIMEOUT(408, 408, "Request Timeout"),
    REQUEST_TOO_LONG(413, 413, "Request Entity Too Large"),
    INVALID_CHARACTER_SET(415, 415, "Invalid Character Set"),
    INTERNAL_SERVER_ERROR(500, 500, "Internal Server Error"),
    BANDWIDTH_LIMIT_EXCEEDED(509, 509, "Bandwidth Exceeded"),
    
    UNKNOWN(-1, -1, "unknown");
    
    private Integer updateStatusCode;
    private Integer searchStatusCode;
    private String errorString;
    
    private CloudSearchStatusCode(Integer updateStatusCode, Integer searchStatusCode, String errorString) {
        this.updateStatusCode = updateStatusCode;
        this.searchStatusCode = searchStatusCode;
        this.errorString = errorString;
    }
    public Integer getUpdateStatusCode() {
        return this.updateStatusCode;
    }

    public Integer getSearchStatusCode() {
        return this.searchStatusCode;
    }
    
    public String getErrorString() {
        return this.errorString;
    }
    
    public static CloudSearchStatusCode fromStatus(int status) {
        for (CloudSearchStatusCode cloudSearchStatusCode : values()) {
            if (cloudSearchStatusCode.getUpdateStatusCode() == status || cloudSearchStatusCode.getSearchStatusCode() == status) {
                return cloudSearchStatusCode;
            }
        }
        
        return UNKNOWN;
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("updateStatusCode", String.valueOf(updateStatusCode))
                      .add("searchStatusCode", String.valueOf(searchStatusCode))
                      .add("errorString", String.valueOf(errorString))
                      .toString();
    }
}
