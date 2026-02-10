package com.age;

import main.com.age.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    StudentService ss;

    @BeforeEach
    void setup() {
        ss = new StudentService();
    }

    @Test
    void testAssertTrue() {
        assertTrue(ss.isEligible(19));
    }

    @Test
    void testAssertFalse() {
        assertFalse(ss.isEligible(17));
    }

    @Test
    void testAssertEquals() {
        assertEquals(true, ss.isEligible(19));
    }

    @Test
    void testAssertNotEquals() {
        assertNotEquals(true, ss.isEligible(17));
    }

    @Test
    void testAssertNotNull() {
        assertNotNull(ss);
    }

    @Test
    void testAssertSame() {
        StudentService ref = ss;
        assertSame(ref, ss);
    }

    @Test
    void testAssertNotSame() {
        StudentService another = new StudentService();
        assertNotSame(ss, another);
    }

    @Test
    void testAssertAll() {
        assertAll(
                () -> assertTrue(ss.isEligible(20)),
                () -> assertFalse(ss.isEligible(15)),
                () -> assertNotNull(ss)
        );
    }

    @Test
    void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> ss.isEligible(-1));
    }

    @Test
    void testFail() {
        fail("Force test failure");
    }
}
