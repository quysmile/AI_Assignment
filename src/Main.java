import service.ManageStudentList;
import ui.StudentMenu;

public class Main {
    public static void main(String[] args) throws Exception {
        ManageStudentList studentList = new ManageStudentList();
        StudentMenu menu = new StudentMenu(studentList);
        menu.run();
    }

}
