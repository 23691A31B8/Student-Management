package com.StudentManagementSystem;

import java.sql.*;

public class StudentDAO {

    Connection con = DBConnection.getConnection();

    // Add Student
    public void addStudent(Student s) {

        String query = "INSERT INTO student VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, s.getStudentId());
            pst.setString(2, s.getName());
            pst.setString(3, s.getBranch());
            pst.setInt(4, s.getYear());
            pst.setString(5, s.getEmail());
            pst.setDouble(6, s.getCgpa());

            pst.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Students
    public void viewStudents() {

        String query = "SELECT * FROM student";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        rs.getString("student_id") + " "
                                + rs.getString("name") + " "
                                + rs.getString("branch") + " "
                                + rs.getInt("year") + " "
                                + rs.getString("email") + " "
                                + rs.getDouble("cgpa"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent(Student s) {

        String query = "UPDATE student SET name=?,branch=?,year=?,email=?,cgpa=? WHERE student_id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, s.getName());
            pst.setString(2, s.getBranch());
            pst.setInt(3, s.getYear());
            pst.setString(4, s.getEmail());
            pst.setDouble(5, s.getCgpa());
            pst.setString(6, s.getStudentId());

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Updated Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(String id) {

        String query = "DELETE FROM student WHERE student_id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Deleted Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search by ID
    public void searchById(String id) {

        String query = "SELECT * FROM student WHERE student_id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, id);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("student_id") + " "
                                + rs.getString("name") + " "
                                + rs.getString("branch") + " "
                                + rs.getInt("year") + " "
                                + rs.getString("email") + " "
                                + rs.getDouble("cgpa"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search by Name
    public void searchByName(String name) {

        String query = "SELECT * FROM student WHERE name=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("student_id") + " "
                                + rs.getString("name") + " "
                                + rs.getString("branch") + " "
                                + rs.getInt("year") + " "
                                + rs.getString("email") + " "
                                + rs.getDouble("cgpa"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Top 5 Students
    public void topStudents() {

        String query = "SELECT * FROM student ORDER BY cgpa DESC LIMIT 5";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        rs.getString("student_id") + " "
                                + rs.getString("name") + " "
                                + rs.getDouble("cgpa"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Branch Report
    public void branchReport(String branch) {

        String query = "SELECT * FROM student WHERE branch=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, branch);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("student_id") + " "
                                + rs.getString("name") + " "
                                + rs.getDouble("cgpa"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}