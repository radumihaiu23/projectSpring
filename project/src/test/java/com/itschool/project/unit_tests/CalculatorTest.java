package com.itschool.project.unit_tests;

import com.itschool.project.utils.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAddition_WithValidInput_ShouldPass() {
        //GIVEN
        int firstNumber = 5;
        int secondNumber = 10;
        int expectedResult = firstNumber + secondNumber;

        //WHEN
        int actualResult = calculator.add(firstNumber, secondNumber);

        //THEN
        assertEquals(expectedResult, actualResult, "The addition result should be equal to the expected result ");
    }

    @Test
    void testAddition_WithResultExceedsMaximumIntegerValue_ShouldFail() {
        //GIVEN
        int a = Integer.MAX_VALUE;
        int b = 1;
        long expectedResult = (long) a + b;

        //WHEN
        int actualResult = calculator.add(a, b);

        //THEN
        assertNotEquals(expectedResult, actualResult);
    }
}