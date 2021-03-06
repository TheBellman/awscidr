package net.parttimepolymath.awscidr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationPropertiesTest {

    @Test
    void getAppName() {
        assertNotNull(ApplicationProperties.getAppName());
    }

}