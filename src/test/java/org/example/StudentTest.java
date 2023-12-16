package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("John", "Doe", "1990-05-15", "Male", "1234567890123");
    }

    @Test
    void calculateAge() {
        int currentYearTest=2023;
        assertEquals(33, student.calculateAge(currentYearTest));
    }

}