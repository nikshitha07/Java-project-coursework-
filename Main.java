import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    // Add student
    public static void addStudent(int id, String name) {
        students.add(new Student(id, name));
        System.out.println("Student added.");
    }

    // Display students
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println("ID: " + s.id + ", Name: " + s.name);
        }
    }

    // Search student by ID
    public static void searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Found: " + s.name);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // fix input bug

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                addStudent(id, name);

            } else if (choice == 2) {
                displayStudents();

            } else if (choice == 3) {
                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();

                searchStudent(id);

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
