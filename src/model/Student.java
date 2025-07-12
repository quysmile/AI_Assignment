package model;

public class Student {
    private int studentID;
    private String fullName;
    private double gpa;

    public Student(int studentID, String fullName, double gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public Student() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty.");
        }
        if (fullName.length() > 50) {
            throw new IllegalArgumentException("Full name must be 50 characters or less.");
        }
        this.fullName = fullName;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", fullName: " + fullName + ", gpa: " + gpa;
    }

}
