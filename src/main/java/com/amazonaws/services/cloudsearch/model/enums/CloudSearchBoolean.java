package com.amazonaws.services.cloudsearch.model.enums;

import com.google.common.base.Objects;

/**
 * This class defines constants for cloudsearch queries
 */
public enum CloudSearchBoolean {
    AND("and"),
    NOT("not"),
    OR("or");

    private String booleanOperator;
    private CloudSearchBoolean(String booleanOperator) {
        this.booleanOperator = booleanOperator;
    }

    public String getName() {
        return this.booleanOperator;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("booleanOperator", this.booleanOperator)
                .toString();

    }
}
