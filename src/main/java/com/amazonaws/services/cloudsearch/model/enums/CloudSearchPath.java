package com.amazonaws.services.cloudsearch.model.enums;

import com.google.common.base.Objects;

/**
 * This class defines constants for paths in cloudsearch
 *
 * @author jmonette
 */
public enum CloudSearchPath {
    BATCH("batch"),
    DOCUMENTS("documents"),
    SEARCH("search");

    private String path;
    private CloudSearchPath(String path) {
        this.path = path;
    }

    public String getName() {
        return this.path;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("path", this.path)
                .toString();

    }

}
