package com.amazonaws.services.cloudsearch.model.exceptions;

/**
 * @author jmonette
 */
public class CloudSearchBadRequestException extends CloudSearchClientException {

    private static final long serialVersionUID = -984706197490201745L;

    public CloudSearchBadRequestException(Integer amazonStatusCode, String message, String entity) {
        super(amazonStatusCode, message, entity);
    }
}
