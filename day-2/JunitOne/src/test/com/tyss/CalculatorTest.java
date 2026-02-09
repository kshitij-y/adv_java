package com.tyss;


import com.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
    Calculator cal;
    @BeforeEach
    public void setup() {
        cal = new Calculator();
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(3, cal.add(1,2));
    }

    @Test
    public void testSubs(){
        Assertions.assertEquals(-1, cal.subtract(1,2));
    }

    @Test
    public void testIsEven() {
        Assertions.assertTrue(cal.isEven(8));
        Assertions.assertFalse(cal.isEven(5));
    }

    @Test
    public void testDivide(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            cal.divide(10,0);
        });
    }

}
