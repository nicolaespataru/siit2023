package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    StudentRepository repository;
    Student studentTest;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
        studentTest = new Student("John", "Doe", "1990-05-15", "Male", "1234567890123");
        repository.addStudent(studentTest);
    }


    @Test
    void addStudent() {
            Student student = Mockito.mock(Student.class);
            repository.addStudent(student);
            assertEquals(1, repository.getStudents().size());
    }

    @Test
    void deleteStudent() {
        Student student = Mockito.mock(Student.class);
        repository.addStudent(student);
        Mockito.when(student.getStudentId()).thenReturn("123");
        repository.deleteStudent("123");
        assertEquals(0, repository.getStudents().size());
    }

    @Test
    void retrieveStudentsByAge() {
        assertEquals(1, repository.retrieveStudentsByAge("28").size());

    }

    @Test
    void listStudents() {
        assertEquals("Doe", repository.listStudents("Last Name").get(0).getLastName());
    }
}