package staffManagement;

import java.util.ArrayList;
import java.util.Iterator;

import static staffManagement.Menus.*;
import static staffManagement.Utilities.*;

public class EmployeeManagement {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void updateEmployee() {
        showAllEmployees();
        System.out.println("\nID:");
        int id = readInt();

        for (Employee e : employees) {
            if (e.getId() == id) {

                if (e instanceof ItTech) {
                    itTechUpdateMenu();
                    int choice = readInt();
                    switch (choice) {
                        case 1 -> updateName(e);
                        case 2 -> updateSalary(e);
                        case 3 -> updateGender(e);
                        case 4 -> updateMonthsWorked(e);
                        case 5 -> updateTechIssuesSolved(e);
                    }
                } else if (e instanceof Programmer) {
                    programmerUpdateMenu();
                    int choice = readInt();
                    switch (choice) {
                        case 1 -> updateName(e);
                        case 2 -> updateSalary(e);
                        case 3 -> updateGender(e);
                        case 4 -> updateMonthsWorked(e);
                        case 5 -> updateBugsInCode(e);
                    }
                } else if (e instanceof Janitor) {
                    janitorUpdateMenu();
                    int choice = readInt();
                    switch (choice) {
                        case 1 -> updateName(e);
                        case 2 -> updateSalary(e);
                        case 3 -> updateGender(e);
                        case 4 -> updateMonthsWorked(e);
                        case 5 -> updateFloorsCleaned(e);
                    }
                } else if (e instanceof ProjectLeader) {
                    projectLeaderUpdateMenu();
                    int choice = readInt();
                    switch (choice) {
                        case 1 -> updateName(e);
                        case 2 -> updateSalary(e);
                        case 3 -> updateGender(e);
                        case 4 -> updateMonthsWorked(e);
                        case 5 -> updateMonthlyComplaints(e);
                        case 6 -> updateProjectsComplete(e);
                    }
                }
            }
        }
    }

    public static void updateName(Employee e) {
        System.out.println("New name: ");
        e.setName(readString());
        System.out.println("\nName updated!");
        pauseCode();
    }

    public static void updateGender(Employee e) {
        System.out.println("New gender: ");
        e.setGender(readString());
        System.out.println("\nGender updated!");
        pauseCode();
    }

    public static void updateSalary(Employee e) {
        System.out.println("New salary: ");
        e.setSalary(readInt());
        System.out.println("\nSalary updated!");
        pauseCode();
    }

    public static void updateMonthsWorked(Employee e) {
        System.out.println("New amount of months worked: ");
        e.setMonthsWorked(readInt());
        System.out.println("\nMonths worked updated!");
        pauseCode();
    }

    public static void updateTechIssuesSolved(Employee e) {
        System.out.println("New monthly average tech issues solved: ");
        ((ItTech) e).setMonthlyIssuesSolved(readInt());
        System.out.println("Tech issues solved updated!");
        pauseCode();
    }

    public static void updateFloorsCleaned(Employee e) {
        System.out.println("New monthly average floors cleaned: ");
        ((Janitor) e).setMonthlyFloorsCleaned(readInt());
        System.out.println("Amount of floors cleaned updated!");
        pauseCode();
    }

    public static void updateBugsInCode(Employee e) {
        System.out.println("New monthly average bugs in code: ");
        ((Programmer) e).setMonthlyBugsInCode(readInt());
        System.out.println("Amount of bugs in code updated!");
        pauseCode();
    }

    public static void updateMonthlyComplaints(Employee e) {
        System.out.println("New monthly average amount of complaints: ");
        ((ProjectLeader) e).setMonthlyEmployeeComplaints(readInt());
        System.out.println("Amount of complaints updated!");
        pauseCode();
    }

    public static void updateProjectsComplete(Employee e) {
        System.out.println("New monthly average amount of projects complete: ");
        ((ProjectLeader) e).setMonthlyProjectsComplete(readInt());
        System.out.println("Amount of projects completed updated!");
        pauseCode();
    }

    public static Employee findEmployeeById() {
        System.out.println("ID: ");
        int id = readInt();

        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static void removeEmployee() {
        Iterator<Employee> iter = employees.iterator();
        showAllEmployees();
        System.out.println("\nID: ");

        int id = readInt();

        while (iter.hasNext()) {
            Employee e = iter.next();

            if (e.getId() == id) {
                System.out.println(e.getName() + " has been removed");
                iter.remove();
                pauseCode();
            }
        }
    }

    public static void removeEmployee2() {
        showAllEmployees();
        System.out.println("\nID:");
        int id = readInt();

        for (int i = employees.size() - 1; i > -1; i--) {

            if (employees.get(i).getId() == id) {

                System.out.println(employees.get(i).getName() + " has been removed");
                employees.remove(employees.get(i));
                pauseCode();
            }
        }
    }

    public static void addEmployee(Employee e) {
        employees.add(e);
        System.out.println(e.getName() + " added to employee list");
        pauseCode();
    }

    public static Employee createEmployee(){
        System.out.println("Name:");
        String name = readString();

        System.out.println("Salary:");
        int salary = readInt();

        System.out.println("Gender:");
        String gender = readString();

        System.out.println("Months worked:");
        int monthsWorked = readInt();

        return new Employee(name,salary,gender,monthsWorked) {
            @Override
            public void assignBonus(Employee e) {
            }
        };
    }

    public static ItTech createItTech() {

        Employee emp = createEmployee();

        System.out.println("Monthly average issues solved:");
        int dailyIssuesSolved = readInt();

        return new ItTech(emp.getName(), emp.getSalary(), emp.getGender(), emp.getMonthsWorked(), dailyIssuesSolved);
    }

    public static Programmer createProgrammer() {

        Employee emp = createEmployee();

        System.out.println("Monthly average bugs in code:");
        int bugsInCode = readInt();

        return new Programmer(emp.getName(), emp.getSalary(), emp.getGender(), emp.getMonthsWorked(), bugsInCode);
    }

    public static Janitor createJanitor() {

        Employee emp = createEmployee();

        System.out.println("Monthly average floors cleaned:");
        int dailyFloorsCleaned = readInt();

        return new Janitor(emp.getName(),emp.getSalary(),emp.getGender(),emp.getMonthsWorked(), dailyFloorsCleaned);
    }

    public static ProjectLeader createProjectLeader() {

        Employee emp = createEmployee();

        System.out.println("Monthly average employee complaints:");
        int employeeComplaints = readInt();

        System.out.println("Monthly average projects complete:");
        int projectsComplete = readInt();


        return new ProjectLeader(emp.getName(), emp.getSalary(), emp.getGender(), emp.getMonthsWorked(),
                employeeComplaints, projectsComplete);
    }

    public static void showAllEmployees() {
        showEmployeeHeader();

        for (Employee e : employees) {
            System.out.println(" " + fixString(4, String.valueOf(e.getId())) +
                    fixString(12, e.getName()) + fixString(12, String.valueOf(e.getSalary())) +
                    fixString(12, String.valueOf(e.getMonthsWorked())) +
                    fixString(12, e.getGender()));
        }
        menuFoot();
    }

    public static void showAllItTechs() {
        showItTechHeader();

        for (Employee e : employees) {
            if (e instanceof ItTech) {
                System.out.println(" " + fixString(4, String.valueOf(e.getId())) +
                        fixString(12, e.getName()) + fixString(12, String.valueOf(e.getSalary())) +
                        fixString(12, String.valueOf(e.getMonthsWorked())) +
                        fixString(12, e.getGender()) +
                        fixString(12, String.valueOf(((ItTech) e).getMonthlyIssuesSolved())));
            }
        }
        menuFoot();
    }

    public static void showAllJanitors() {
        showJanitorHeader();

        for (Employee e : employees) {
            if (e instanceof Janitor) {
                System.out.println(" " + fixString(4, String.valueOf(e.getId())) +
                        fixString(12, e.getName()) + fixString(12, String.valueOf(e.getSalary())) +
                        fixString(12, String.valueOf(e.getMonthsWorked())) +
                        fixString(12, e.getGender()) +
                        fixString(12, String.valueOf(((Janitor) e).getMonthlyFloorsCleaned())));
            }
        }
        menuFoot();
    }

    public static void showAllProgrammers() {
        showProgrammerHeader();

        for (Employee e : employees) {
            if (e instanceof Programmer) {
                System.out.println(" " + fixString(4, String.valueOf(e.getId())) +
                        fixString(12, e.getName()) + fixString(12, String.valueOf(e.getSalary())) +
                        fixString(12, String.valueOf(e.getMonthsWorked())) +
                        fixString(12, e.getGender()) +
                        fixString(12, String.valueOf(((Programmer) e).getMonthlyBugsInCode())));
            }
        }
        menuFoot();
    }

    public static void showAllProjectLeaders() {
        showProjectLeaderHeader();

        for (Employee e : employees) {
            if (e instanceof ProjectLeader) {
                System.out.println(" " + fixString(4, String.valueOf(e.getId())) +
                        fixString(12, e.getName()) + fixString(12, String.valueOf(e.getSalary())) +
                        fixString(12, String.valueOf(e.getMonthsWorked())) +
                        fixString(12, e.getGender()) +
                        fixString(12, String.valueOf(((ProjectLeader) e).getMonthlyEmployeeComplaints())) +
                        fixString(12, String.valueOf(((ProjectLeader) e).getMonthlyProjectsComplete())));
            }
        }
        menuFoot();
    }

    public static void sortBySalary() {
        employees.sort((Employee e1, Employee e2) -> e1.getSalary() - e2.getSalary());
        showAllEmployees();
        System.out.println("Sorted by salary");
        pauseCode();

    }

    public static void sortByName() {
        employees.sort((Employee e1, Employee e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        showAllEmployees();
        System.out.println("Sorted by name");
        pauseCode();
    }

    public static void sortByFloorsCleaned() {
        employees.sort(new SortByFloorsCleaned());
        showAllJanitors();
        System.out.println("Janitors sorted by floors cleaned");
        pauseCode();

    }

    public static void sortByMonthsWorked() {
        employees.sort((Employee e1, Employee e2) -> e1.getMonthsWorked() - e2.getMonthsWorked());
        System.out.println("Sorted by months worked.");
        showAllEmployees();
        pauseCode();
    }


    public static void loadDb() {

        ItTech it1 = new ItTech("Jesper", 30000, "Male", 27, 40);
        ItTech it2 = new ItTech("Jessica", 32000, "Female", 32, 50);
        ItTech it3 = new ItTech("Bert", 28000, "Male", 14, 30);

        Programmer p1 = new Programmer("Sven", 39000, "male", 44, 40);
        Programmer p2 = new Programmer("Lars", 38000, "male", 55, 50);
        Programmer p3 = new Programmer("Eva", 42000, "female", 12, 30);
        Programmer p4 = new Programmer("Lenny", 46000, "male", 5, 20);
        Programmer p5 = new Programmer("Ronja", 48000, "female", 65, 60);

        Janitor j1 = new Janitor("Tuva", 22000, "female", 55, 100);
        Janitor j2 = new Janitor("Gustav", 24000, "male", 22, 70);
        Janitor j3 = new Janitor("Kenny", 28000, "male", 22, 120);

        ProjectLeader pl1 = new ProjectLeader("Valentina", 55000, "female", 66,
                10, 2);
        ProjectLeader pl2 = new ProjectLeader("Alex", 58000, "male", 88,
                7, 3);

        employees.add(it1);
        employees.add(it2);
        employees.add(it3);
        employees.add(p1);
        employees.add(p2);
        employees.add(p3);
        employees.add(p4);
        employees.add(p5);
        employees.add(j1);
        employees.add(j2);
        employees.add(j3);
        employees.add(pl1);
        employees.add(pl2);

    }


}
