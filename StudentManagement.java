package com.StudentManagementSystem;

import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Display Top 5 Students");
            System.out.println("8. Branch-wise Report");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Student ID: ");
                String id = sc.next();

                System.out.print("Enter Name: ");
                String name = sc.next();

                System.out.print("Enter Branch: ");
                String branch = sc.next();

                System.out.print("Enter Year: ");
                int year = sc.nextInt();

                System.out.print("Enter Email: ");
                String email = sc.next();

                System.out.print("Enter CGPA: ");
                double cgpa = sc.nextDouble();

                Student s = new Student(id, name, branch, year, email, cgpa);

                dao.addStudent(s);
                break;

            case 2:

                dao.viewStudents();
                break;

            case 3:

                System.out.print("Enter Student ID to update: ");
                String uid = sc.next();

                System.out.print("Enter New Name: ");
                String uname = sc.next();

                System.out.print("Enter New Branch: ");
                String ubranch = sc.next();

                System.out.print("Enter New Year: ");
                int uyear = sc.nextInt();

                System.out.print("Enter New Email: ");
                String uemail = sc.next();

                System.out.print("Enter New CGPA: ");
                double ucgpa = sc.nextDouble();

                Student updatedStudent =
                        new Student(uid, uname, ubranch, uyear, uemail, ucgpa);

                dao.updateStudent(updatedStudent);

                break;

            case 4:

                System.out.print("Enter Student ID to delete: ");
                String deleteId = sc.next();

                dao.deleteStudent(deleteId);

                break;

            case 5:

                System.out.print("Enter Student ID: ");
                String sid = sc.next();

                dao.searchById(sid);

                break;

            case 6:

                System.out.print("Enter Student Name: ");
                String sname = sc.next();

                dao.searchByName(sname);

                break;

            case 7:

                dao.topStudents();

                break;

            case 8:

                System.out.print("Enter Branch: ");
                String bname = sc.next();

                dao.branchReport(bname);

                break;

            case 9:

                System.out.println("Thank You!");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice");
            }
        }
    }
}