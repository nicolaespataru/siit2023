package org.example;

import java.util.logging.Level;


import static org.example.Student.logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentRepository repo = new StudentRepository();

        try {

            Student student1 = new Student("John", "Doe", "1990-05-15", "Male", "1234567890123");
            repo.addStudent(student1);


            repo.deleteStudent("1234567890123");


            Student student2 = new Student("Jane", "Doe", "1995-08-20", "Female", "1234567890124");
            repo.addStudent(student2);
            repo.retrieveStudentsByAge("28").forEach(System.out::println);


            repo.listStudents("Last Name").forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }

    }
}
