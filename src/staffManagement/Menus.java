package staffManagement;

import java.io.IOException;

import static staffManagement.EmployeeManagement.*;
import static staffManagement.EmployeeStatistics.*;
import static staffManagement.Utilities.*;

public class Menus {

    public static void mainMenu() throws IOException {
        boolean loop = true;
        System.out.println("\nWelcome to BestCompanys staff program!");

        while (loop) {
            System.out.println("""
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                        Main Menu
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                        
                    1. Management Menu
                    2. Statistics
                    3. Assign Bonus
                    4. LoadDB
                    5. TEST
                    0. Exit
                    ____________________________________________________
                    """);

            int choice = readInt();
            switch (choice) {
                case 1 -> managementMenu();
                case 2 -> statsMenu();
                case 3 -> {
                    showAllEmployees();
                    Employee e = findEmployeeById();
                    e.assignBonus(e);
                }
                case 4-> EmployeeManagement.loadDb();
                case 5 -> genderDistributionWithStreams();
                case 0 -> {
                    System.out.println("Thanks, bye!");
                    saveToFile();
                    loop = false;
                }
            }
        }
    }

    public static void statsMenu() {
        boolean loop = true;

        while (loop) {
            System.out.println("""
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                        Stats Menu
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                        
                    1. Highest paid employee
                    2. Lowest paid employee
                    3. Gender distribution
                    4. Current amount of employees
                    5. Average salary
                    0. Exit to Main Menu
                    ____________________________________________________
                    """);

            int choice = readInt();
            switch (choice) {
                case 1 -> getHighestSalaryWithStreams();
                case 2 -> getLowestSalaryWithStreams();
                case 3 -> genderDistributionWithStreams();
                case 4 -> staffSize();
                case 5 -> averageSalaryWithStreams();
                case 0 -> loop = false;
            }
        }
    }

    public static void managementMenu() {
        boolean loop = true;

        while (loop) {
            System.out.println("""
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                     Management Menu
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                        
                    1. Add Employee
                    2. Update Employee information
                    3. Remove Employee
                    4. Show Employees
                    5. Sort Employees
                    0. Exit to Main Menu
                    ____________________________________________________
                    """);

            int choice = readInt();
            switch (choice) {
                case 1 -> addEmployeeMenu();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> showEmployeeMenu();
                case 5 -> sortEmployeeMenu();
                case 0 -> loop = false;
            }
        }
    }

    public static void sortEmployeeMenu() {
        System.out.println("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                Sort Employee Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    
                1. Sort by salary
                2. Sort by name
                3. Sort Janitors by floors cleaned
                               
                ____________________________________________________
                """);

        int choice = readInt();
        switch (choice) {
            case 1 -> sortBySalary();
            case 2 -> sortByName();
            case 3 -> sortByFloorsCleaned();
            case 4 -> sortByMonthsWorked();
        }

    }

    public static void addEmployeeMenu() {

        System.out.println("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                Add Employee Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    
                1. Add It-tech
                2. Add Programmer
                3. Add Janitor
                4. Add Project Leader
                ____________________________________________________
                """);

        int choice = readInt();
        switch (choice) {
            case 1 -> addEmployee(createItTech());
            case 2 -> addEmployee(createProgrammer());
            case 3 -> addEmployee(createJanitor());
            case 4 -> addEmployee(createProjectLeader());
        }
    }

    public static void showEmployeeMenu() {
        boolean loop = true;

        while (loop) {
            System.out.println("""
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                     Show Employee Menu
                    -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                        
                    1. Show all employees
                    2. Show all It-techs
                    3. Show all Programmers
                    4. Show all Janitors
                    5. Show all ProjectLeaders
                    0. Exit to Main Menu
                    ____________________________________________________
                    """);

            int choice = readInt();
            switch (choice) {
                case 1 -> {
                    showAllEmployees();
                    pauseCode();
                }
                case 2 -> {
                    showAllItTechs();
                    pauseCode();
                }
                case 3 -> {
                    showAllProgrammers();
                    pauseCode();
                }
                case 4 -> {
                    showAllJanitors();
                    pauseCode();
                }
                case 5 -> {
                    showAllProjectLeaders();
                    pauseCode();
                }
                case 0 -> loop = false;
                default -> System.out.println("Faulty Input");
            }
        }
    }

    public static void itTechUpdateMenu() {
        System.out.println("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  It-tech updater
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    
                1. Update name
                2. Update salary
                3. Update gender
                4. Update months worked
                5. Update daily average tech issues solved
                ____________________________________________________
                """);
    }

    public static void programmerUpdateMenu() {
        System.out.println("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                 Programmer updater
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    
                1. Update name
                2. Update salary
                3. Update gender
                4. Update months worked
                5. Update daily average amount of bugs
                ____________________________________________________
                """);
    }

    public static void janitorUpdateMenu() {
        System.out.println("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                 Janitor updater
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    
                1. Update name
                2. Update salary
                3. Update gender
                4. Update months worked
                5. Update daily average floors cleaned
                ____________________________________________________
                """);
    }

    public static void projectLeaderUpdateMenu() {
        System.out.println("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                              Project leader updater
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    
                1. Update name
                2. Update salary
                3. Update gender
                4. Update months worked
                5. Update monthly complaints
                6. Update projects complete
                ____________________________________________________
                """);
    }

    public static void showEmployeeHeader() {
        System.out.print("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                 ID    Name          Salary     MonthsWorked     Gender
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                """);
    }

    public static void menuFoot() {
        System.out.println("""
                _________________________________________________________
                """);
    }

    public static void showItTechHeader() {
        System.out.print("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                 ID    Name          Salary     MonthsWorked     Gender   SolvedTechIssues
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                """);
    }

    public static void showJanitorHeader() {
        System.out.print("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                 ID    Name          Salary     MonthsWorked     Gender    FloorsCleaned
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                """);
    }

    public static void showProgrammerHeader() {
        System.out.print("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                 ID    Name          Salary     MonthsWorked     Gender    BugsInCode
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                """);
    }

    public static void showProjectLeaderHeader() {
        System.out.print("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                 ID    Name          Salary     MonthsWorked     Gender    Complaints  ProjectsComplete
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                """);
    }
}
