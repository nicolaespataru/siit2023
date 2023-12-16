package org.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class StudentRepository {
    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());

    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(String studentId) {
        if (studentId.isEmpty()) {
            throw new IllegalArgumentException("Student ID should not be empty.");
        }
        students.removeIf(student -> student.getStudentId().equals(studentId));
        logger.info("Student with ID " + studentId + " deleted successfully.");
    }

    public List<Student> retrieveStudentsByAge(String age) {
        if (!age.matches("\\d+") || Integer.parseInt(age) < 0) {
            throw new IllegalArgumentException("Age should be a positive number.");
        }
        int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.calculateAge(currentYear) == Integer.parseInt(age)) {
                result.add(student);
            }
        }
        return students;
    }

    public List<Student> listStudents(String orderBy) {
        if (orderBy.isEmpty()) {
            throw new IllegalArgumentException("Order by field should not be empty.");
        }

        if (orderBy.equalsIgnoreCase("Last Name")) {
            students.sort(Comparator.comparing(Student::getLastName));
        } else if (orderBy.equalsIgnoreCase("Birth Date")) {
            students.sort(Comparator.comparing(Student::getDob));
        } else {
            throw new IllegalArgumentException("Invalid order by field. Use 'Last Name' or 'Birth Date'.");
        }
        return students;
    }

    public List<Student> getStudents() {
        return students;
    }
}