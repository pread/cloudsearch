package com.amazonaws.services.cloudsearch.model.enums;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author Phillip Read
 */
public class CloudSearchStatusCodeTest {

    @Test
    public void testFromStatusUnknown() {
        Assert.assertThat(CloudSearchStatusCode.fromStatus(30), is(CloudSearchStatusCode.UNKNOWN));
    }
}
