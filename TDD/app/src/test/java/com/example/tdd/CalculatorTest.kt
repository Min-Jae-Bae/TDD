package com.example.tdd

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

@Nested
@DisplayName("Calculator Test")
public class CalculatorTest {

    private val calculatorTest: Calculator = Calculator()

    @DisplayName("Sum Test")
    @Test
    fun testSum() {
        val expected = 42
        assertEquals(expected, calculatorTest.sum(40, 2))
    }

    @DisplayName("Division Test")
    @Test
    fun testDivision() {
        val expected = 12
        assertEquals(expected, calculatorTest.division(24, 2))
    }
}