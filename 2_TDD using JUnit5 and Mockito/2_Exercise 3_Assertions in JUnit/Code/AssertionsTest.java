package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // ✅ assertEquals: Check if values are equal
        assertEquals(5, 2 + 3);

        // ✅ assertTrue: Check if a condition is true
        assertTrue(5 > 3);

        // ✅ assertFalse: Check if a condition is false
        assertFalse(5 < 3);

        // ✅ assertNull: Check if something is null
        assertNull(null);

        // ✅ assertNotNull: Check if something is NOT null
        assertNotNull(new Object());
    }
}
