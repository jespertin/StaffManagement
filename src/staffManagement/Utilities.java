package staffManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilities {

    public static Scanner sc = new Scanner(System.in);

    public static int readInt() {
        int number = 0;
        boolean loop = true;

        while (loop) {
            try {
                number = sc.nextInt();
                loop = false;

            } catch (InputMismatchException e) {
                System.out.println("Only numerical values accepted, try again.");

            } finally {
                sc.nextLine();
            }
        }
        return number;
    }

    public static String readString() {
        return sc.nextLine();
    }

    public static String fixString(int wantedSize, String stringToFix) {
        if (stringToFix.length() < wantedSize) {

            while (stringToFix.length() < wantedSize) {
                stringToFix = stringToFix + " ";
            }
            return stringToFix + "  ";
        } else return stringToFix.substring(0, wantedSize) + "  ";
    }

    public static void pauseCode() {
        System.out.println("Press ENTER key to continue");
        sc.nextLine();
    }

    public static void readFromFile() throws IOException {
        ArrayList<Employee> emp;

        FileInputStream input = new FileInputStream
                ("C:\\Users\\jespe\\IdeaProjects\\StaffManagement\\src\\staffManagement\\EmployeeDB.txt");

        try {
            ObjectInputStream source = new ObjectInputStream(input);
            emp = (ArrayList<Employee>) source.readObject();

            if (emp.size() > 0)
                Employee.counter = emp.get(emp.size() - 1).getId() + 1;
            EmployeeManagement.employees = emp;

        } catch (EOFException | ClassNotFoundException eo) {
            System.out.println("File is empty");
        }
    }

    public static void saveToFile() throws IOException {
        FileOutputStream output = new FileOutputStream
                ("C:\\Users\\jespe\\IdeaProjects\\StaffManagement\\src\\staffManagement\\EmployeeDB.txt");
        ObjectOutputStream destination = new ObjectOutputStream(output);
        destination.writeObject(EmployeeManagement.employees);
        destination.close();
    }


}
