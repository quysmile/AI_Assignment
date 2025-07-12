package ui;

import java.util.Scanner;

import model.Student;
import service.ManageStudentList;

public class StudentMenu {
    private ManageStudentList studentList;
    // private int checkChoice = 0;
    // private int secondChoice = 0;

    public StudentMenu(ManageStudentList studentList) {
        this.studentList = studentList;
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------* MANAGE STUDENTS SERVICE *-----------");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Search student");
        System.out.println("4. Display all");
        System.out.println("5. Exit");
        System.out.println("\nEnter your choice: ");
        int yourChoice = scanner.nextInt();

        switch (yourChoice) {
            case 1:
                System.out.println("Enter number of Student want to add: ");
                int numberOfStudent = scanner.nextInt();
                for (int i = 0; i < numberOfStudent; i++) {
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();

                    Student student = new Student(id, fullName, gpa);
                    studentList.addAStudent(student);
                }
                secondMenu();
                break;
            case 2:
                System.out.print("Enter ID Student want to remove: ");
                int IdStudentRemove = scanner.nextInt();
                System.out.println("hehe");
                studentList.deleteAStudent(IdStudentRemove);
                secondMenu();
                break;
            case 3:
                System.out.print("Enter name Student want to search: ");
                scanner.nextLine();
                String nameToSearch = scanner.nextLine();
                studentList.searchForStudent(nameToSearch);
                secondMenu();
                break;
            case 4:
                studentList.printAllStudent();
                secondMenu();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid Number!");
                break;
        }
        scanner.close();
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
