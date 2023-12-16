package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class Student {
    static final Logger logger = Logger.getLogger(Student.class.getName());

    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String studentId;

    public Student(String firstName, String lastName, String dob, String gender, String studentId) {
        validateInput(firstName, lastName, dob, gender, studentId);
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            this.dob = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Error parsing date of birth", e);
        }
        this.gender = gender.toUpperCase();
        this.studentId = studentId;
    }

    public int calculateAge(int currentYear) {
        int birthYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(dob));
        return currentYear - birthYear;
    }

    private void validateInput(String firstName, String lastName, String dob, String gender, String studentId) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("First name and last name should not be empty.");
        }
        int birthYear = Integer.parseInt(dob.split("-")[0]);
        if (birthYear < 1900 && birthYear < (new Date()).getYear()) {
            throw new IllegalArgumentException("Date of birth should be between 1900 and current year - 2023.");
        }
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender should be 'Male' or 'Female'.");
        }
        if (studentId.isEmpty()) {
            throw new IllegalArgumentException("Student ID (CNP) should not be empty.");
        }
    }

    public String getStudentId() {
        return this.studentId;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getDob() {
            return dob;
        }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dateFormat.format(dob) +
                ", gender='" + gender + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}