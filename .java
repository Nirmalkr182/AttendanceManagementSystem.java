import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Define a Student class
class Student {
    int id;
    String name;
    boolean attendance;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.attendance = false; // Default attendance is false
    }
}

// Main Attendance System Class
public class AttendanceManagementSystem {
    static HashMap<Integer, Student> students = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populated students
        students.put(1, new Student(1, "Alice"));
        students.put(2, new Student(2, "Bob"));
        students.put(3, new Student(3, "Charlie"));

        System.out.println("Welcome to the Online Attendance Management System!");
        while (true) {
            System.out.println("\nSelect a Role:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    studentMenu();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }

    // Admin Menu
    static void adminMenu() {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Mark Attendance");
        System.out.println("3. View Attendance");
        System.out.println("4. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                markAttendance();
                break;
            case 3:
                viewAttendance();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid Choice! Try again.");
        }
    }

    // Add a new student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.put(id, new Student(id, name));
        System.out.println("Student Added Successfully!");
    }

    // Mark attendance for students
    static void markAttendance() {
        System.out.println("Mark Attendance:");
        for (Student student : students.values()) {
            System.out.print("Is " + student.name + " present? (yes/no): ");
            String response = scanner.next();
            student.attendance = response.equalsIgnoreCase("yes");
        }
        System.out.println("Attendance Marked Successfully!");
    }

    // View attendance records
    static void viewAttendance() {
        System.out.println("Attendance Records:");
        for (Student student : students.values()) {
            System.out.println(student.name + ": " + (student.attendance ? "Present" : "Absent"));
        }
    }

    // Student Menu
    static void studentMenu() {
        System.out.print("Enter Your Student ID: ");
        int id = scanner.nextInt();
        if (students.containsKey(id)) {
            Student student = students.get(id);
            System.out.println("Hello, " + student.name + "!");
            System.out.println("Your Attendance: " + (student.attendance ? "Present" : "Absent"));
        } else {
            System.out.println("Student ID not found!");
        }
    }
}
