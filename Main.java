import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Students> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            // 1. Add Student
            if (choice == 1) {

                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter roll number: ");
                int rollNumber = sc.nextInt();

                boolean exists = false;

                for (Students student : students) {
                    if (student.rollNumber == rollNumber) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Roll number already exists!");
                    continue;
                }

                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter department: ");
                String department = sc.nextLine();

                Students newStudent =
                        new Students(name, rollNumber, age, department);

                students.add(newStudent);

                System.out.println("Student added successfully!");
            }

            // 2. View Students
            else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No students found!");
                } else {

                    System.out.println("\n===== Student Details =====");

                    for (Students student : students) {

                        System.out.println("--------------------------");
                        System.out.println("Name: " + student.name);
                        System.out.println("Roll Number: " + student.rollNumber);
                        System.out.println("Age: " + student.age);
                        System.out.println("Department: " + student.department);
                    }

                    System.out.println("--------------------------");
                }
            }

            // 3. Search Student
            else if (choice == 3) {

                System.out.print("Enter roll number to search: ");
                int searchRoll = sc.nextInt();

                boolean found = false;

                for (Students student : students) {

                    if (student.rollNumber == searchRoll) {

                        System.out.println("\nStudent found!");
                        System.out.println("Name: " + student.name);
                        System.out.println("Roll Number: " + student.rollNumber);
                        System.out.println("Age: " + student.age);
                        System.out.println("Department: " + student.department);

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // 4. Update Student
            else if (choice == 4) {

                System.out.print("Enter roll number to update: ");
                int updateRoll = sc.nextInt();
                sc.nextLine();

                boolean found = false;

                for (Students student : students) {

                    if (student.rollNumber == updateRoll) {

                        System.out.print("Enter new name: ");
                        student.name = sc.nextLine();

                        System.out.print("Enter new age: ");
                        student.age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new department: ");
                        student.department = sc.nextLine();

                        System.out.println("Student updated successfully!");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // 5. Delete Student
            else if (choice == 5) {

                System.out.print("Enter roll number to delete: ");
                int deleteRoll = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).rollNumber == deleteRoll) {

                        students.remove(i);

                        System.out.println("Student deleted successfully!");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // 6. Exit
            else if (choice == 6) {

                System.out.println("Thank you!");
                break;
            }

            // Invalid choice
            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}