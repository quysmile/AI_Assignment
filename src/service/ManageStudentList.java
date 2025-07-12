package service;

import java.util.ArrayList;

import model.Student;

public class ManageStudentList extends ArrayList<Student> implements StudentService {

    @Override
    public void addAStudent(Student student) {
        int size = this.size();
        for (int i = 0; i < size; i++) {
            if (this.get(i).getStudentID() == student.getStudentID()) {
                throw new IllegalArgumentException("The Student ID has existed!");
            }
        }
        this.add(student);
        System.out.println("Student added successfully.");

    }

    @Override
    public void deleteAStudent(int ID) {
        int res = 0;

        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.get(i).getStudentID() == ID) {
                this.remove(i);
                res = 1;
            }
        }

        if (res == 1) {
            System.out.println("Remove Successfully!");
        } else {
            System.out.println("No Student with ID " + ID + " in the list");
        }
    }

    @Override
    public void searchForStudent(String nameStudentFind) {
        nameStudentFind = nameStudentFind.toLowerCase();
        int checkEmty = 0;
        int size = this.size();
        for (int i = 0; i < size; i++) {
            Student currentStudent = this.get(i);
            String currentName = currentStudent.getFullName().toLowerCase();
            if (currentName.contains(nameStudentFind)) {
                System.out.println(currentStudent.toString());
                checkEmty++;
            }
        }
        if (checkEmty == 0) {
            System.out.println("No Students in the list have name " + nameStudentFind);
        }
    }

    @Override
    public void printAllStudent() {
        int size = this.size();
        System.out.printf("%-10s%-50s%-6s\n", "ID", "Full Name", "GPA");
        for (int i = 0; i < size; i++) {
            Student currentStudent = this.get(i);
            System.out.printf("%-10d%-50s%-6.2f\n", currentStudent.getStudentID(), currentStudent.getFullName(),
                    currentStudent.getGPA());
        }
    }

}
