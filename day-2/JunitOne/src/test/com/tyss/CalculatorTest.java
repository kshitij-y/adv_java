package com.tyss;


import com.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;


public class CalculatorTest {
    static Calculator cal;

    @BeforeAll
     static void setup() {
        cal = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "0, 0, 0",
            "-5, 10, 5"
    })
    public void testAdd(int a, int b, int expectedRes) {
        Assertions.assertEquals(expectedRes, cal.add(a,b));
    }

    @Test
    public void testSubs(){
        Assertions.assertEquals(-1, cal.subtract(1,2));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, -2, -4, -6})
    public void testIsEven(int number) {
        Assertions.assertTrue(cal.isEven(number));
    }

    @Test
    public void testDivide(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            cal.divide(10,0);
        });
    }

    private static Stream<Arguments> provideDivisionTestCases() {
        return Stream.of(
                Arguments.of(20, 4, 5),
                Arguments.of(10, 2, 5),
                Arguments.of(15, 5, 3),
                Arguments.of(0, 7, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDivisionTestCases")
    public void testDivideWithMethodSource(int a, int b, int expected) {
        Assertions.assertEquals(expected, cal.divide(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/data.csv", numLinesToSkip = 0)
    void testSumUsingCSVfileSource(int a, int b, int expected) {
        Assertions.assertEquals(expected, cal.add(a,b));
    }






}
