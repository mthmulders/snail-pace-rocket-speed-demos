package de.bmarwell.snailspace.demo4.app.common.value;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void isNullOrEmpty() throws InterruptedException {
        assertTrue(StringUtils.isNullOrEmpty(null));
        assertTrue(StringUtils.isNullOrEmpty(""));
        assertFalse(StringUtils.isNullOrEmpty("test"));
    }

}
