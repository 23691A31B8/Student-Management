package com.StudentManagementSystem;

public class Student {

    private String studentId;
    private String name;
    private String branch;
    private int year;
    private String email;
    private double cgpa;

    public Student(String studentId, String name,
                   String branch, int year,
                   String email, double cgpa) {

        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.year = year;
        this.email = email;
        this.cgpa = cgpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public int getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }

    public double getCgpa() {
        return cgpa;
    }
}