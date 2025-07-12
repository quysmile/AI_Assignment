package ui;

import java.util.Scanner;

import model.Student;
import service.ManageStudentList;

public class StudentMenu {
    private ManageStudentList studentList;
    private final Scanner scanner = new Scanner(System.in);

    public StudentMenu(ManageStudentList studentList) {
        this.studentList = studentList;
    }

    public void run() {
        printMainMenu();

        System.out.print("\nEnter your choice: ");
        int yourChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (yourChoice) {
            case 1:
                handleAddStudents();
                break;
            case 2:
                handleDeleteStudent();
                break;
            case 3:
                handleSearchStudent();
                break;
            case 4:
                handleDisplayAll();
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Number!");
        }
        secondMenu();
    }

    private void printMainMenu() {
        System.out.println("----------* MANAGE STUDENTS SERVICE *-----------");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Search student");
        System.out.println("4. Display all");
        System.out.println("5. Exit");
    }

    private void handleAddStudents() {
        System.out.print("Enter number of students to add: ");
        int numberOfStudent = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudent; i++) {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Full Name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();

            Student student = new Student(id, fullName, gpa);
            studentList.addAStudent(student);
        }
    }

    private void handleDeleteStudent() {
        System.out.print("Enter ID of student to remove: ");
        int id = scanner.nextInt();
        studentList.deleteAStudent(id);
    }

    private void handleSearchStudent() {
        System.out.print("Enter name of student to search: ");
        String name = scanner.nextLine();
        System.out.print("\n");
        studentList.searchForStudent(name);
    }

    private void handleDisplayAll() {
        studentList.printAllStudent();
    }

    public void secondMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1.Back To Menu");
        System.out.println("2.Exit");
        System.out.print("Your Choice: ");
        int secondChoice = scanner.nextInt();

        switch (secondChoice) {
            case 1:
                run();
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Invalid Number!");
                break;
        }
        scanner.close();

    }
}
