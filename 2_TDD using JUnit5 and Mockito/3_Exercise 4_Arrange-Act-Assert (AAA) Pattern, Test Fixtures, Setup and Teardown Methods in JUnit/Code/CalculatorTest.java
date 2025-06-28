//package com.example;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class CalculatorTest {
//    @Test
//    void testAdd() {
//        Calculator calc = new Calculator();
//        assertEquals(8, calc.add(5, 3));
//    }
//}
package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // ✅ Arrange
        calculator = new Calculator();
        System.out.println("Calculator setup done.");
    }

    @AfterEach
    void tearDown() {
        // Cleanup logic (if needed)
        System.out.println("Test completed.\n");
    }

    @Test
    void testAddition() {
        // ✅ Act
        int result = calculator.add(2, 3);

        // ✅ Assert
        assertEquals(5, result, "Addition should return 5");
    }

    @Test
    void testAdditionNegative() {
        int result = calculator.add(-4, -6);
        assertEquals(-10, result, "Addition with negatives failed");
    }
}

