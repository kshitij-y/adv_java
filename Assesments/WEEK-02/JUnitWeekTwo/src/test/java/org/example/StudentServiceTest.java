package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {
    StudentService ss;
    @BeforeEach
    public void setup(){
        ss = new StudentService();
    }
    @Test
    @DisplayName("Test Grade Calculation")
    public void testGradeCalculation(){
        assertAll(
                () -> assertEquals("Distinction", ss.calculateGrade(80)),
                () -> assertEquals("First Class", ss.calculateGrade(65)),
                () -> assertEquals("Second Class", ss.calculateGrade(55)),
                () -> assertEquals("Fail", ss.calculateGrade(40))

        );
    }

    @Test
    @DisplayName("Test Pass/Fail Status")
    public void testPassFail(){
        assertAll(
                () -> assertTrue(ss.isPassed(75)),
                () -> assertFalse(ss.isPassed(45))
        );
    }

    @Test
    @DisplayName("Test Invalid Input")
    public void testInvalidInput() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,() -> ss.calculateGrade(-10)),
                () -> assertThrows(IllegalArgumentException.class,() -> ss.calculateGrade(120))
        );
    }
    @Test
    @DisplayName("Test Non-Null Response")
    public void testNonNull() {
        assertNotNull(ss.calculateGrade(70));
    }

}
