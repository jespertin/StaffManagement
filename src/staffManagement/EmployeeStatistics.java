package staffManagement;

import java.text.DecimalFormat;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;

import static staffManagement.EmployeeManagement.employees;
import static staffManagement.Utilities.pauseCode;

public class EmployeeStatistics {

    static DoubleSummaryStatistics salaryStatAll = employees.stream()
            .mapToDouble(e -> e.getSalary())
            .summaryStatistics();

    static DoubleSummaryStatistics statSalaryProgrammers = employees.stream()
            .filter(e -> e instanceof Programmer)
            .mapToDouble(e -> e.getSalary())
            .summaryStatistics();

    static DoubleSummaryStatistics statSalaryItTech = employees.stream()
            .filter(e -> e instanceof ItTech)
            .mapToDouble(e -> e.getSalary())
            .summaryStatistics();

    static DoubleSummaryStatistics statSalaryItJanitor = employees.stream()
            .filter(e -> e instanceof Janitor)
            .mapToDouble(e -> e.getSalary())
            .summaryStatistics();

    static DoubleSummaryStatistics statSalaryProjectLeader = employees.stream()
            .filter(e -> e instanceof ProjectLeader)
            .mapToDouble(e -> e.getSalary())
            .summaryStatistics();

    static DecimalFormat f = new DecimalFormat("##.00");

    public static void highestSalary() {
        int max = 0;
        String nameOfMax = "";
        int idOfMax = 0;

        for (Employee e : employees) {
            if (e.getSalary() >= max) {
                max = e.getSalary();
                nameOfMax = e.getName();
                idOfMax = e.getId();
            }
        }
        System.out.println("The employee " + nameOfMax + " with id number " + idOfMax +
                ", is the highest paid employee with a salary of " + max + "kr");
        pauseCode();
    }

    public static void getHighestSalaryWithStreams(){
        Optional<Employee> maxSalary = employees.stream()
                .max((e1,e2) -> e1.getSalary()-e2.getSalary());

        System.out.println("The employee " + maxSalary.get().getName() + " with id number " + maxSalary.get().getId() +
                ", is the highest paid employee with a salary of " + maxSalary.get().getSalary() + "kr");

        pauseCode();
    }

    public static void lowestSalary() {
        int min = 999999;
        String nameOfMin = "";
        int idOfMax = 0;

        for (Employee e : employees) {
            if (e.getSalary() < min) {
                min = e.getSalary();
                nameOfMin = e.getName();
                idOfMax = e.getId();
            }
        }
        System.out.println("The employee " + nameOfMin + " with id number " + idOfMax +
                ", is the lowest paid employee with a salary of " + min + "kr");
        pauseCode();
    }

    public static void getLowestSalaryWithStreams(){
        Optional<Employee> minSalary = employees.stream()
                .min((e1, e2) -> e1.getSalary() - e2.getSalary());

        System.out.println("The employee " + minSalary.get().getName() + " with id number " + minSalary.get().getId() +
                ", is the lowest paid employee with a salary of " + minSalary.get().getSalary() + "kr");

        pauseCode();
    }

    public static void genderDistribution() {
        double males = 0;
        double females = 0;

        for (Employee e : employees) {
            if (e.getGender().equalsIgnoreCase("Male")) {
                males++;
            } else if (e.getGender().equalsIgnoreCase("female")) {
                females++;
            }
        }
        double percentMale = (males / employees.size()) * 100;
        double percentFemale = (females / employees.size()) * 100;


        System.out.println("The company staff is " + (f.format(percentFemale)) +
                "% female and " + (f.format(percentMale)) + "% male");
        pauseCode();
    }
    public static void genderDistributionWithStreams(){
        long males = employees.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("male"))
                .count();

        double percentMale = (((double)males) / employees.size()) * 100;

        long females = employees.size() - males;
        double percentFemale = (((double)females) / employees.size()) * 100;

        System.out.println("The company staff is:\n" + f.format(percentMale) + "% male \n" +
                f.format(percentFemale) + "% female");

        pauseCode();
    }

    public static void staffSize() {
        System.out.println("The company has in total a staff of " + employees.size() + " employees.");
        pauseCode();
    }

    public static void averageSalary() {
        int totalSalary = 0;

        int itTechSalary = 0;
        int itTechCounter = 0;

        int programmerSalary = 0;
        int programmerCounter = 0;

        int janitorSalary = 0;
        int janitorCounter = 0;

        int projectLeaderSalary = 0;
        int projectLeaderCounter = 0;

        for (Employee e : employees) {
            totalSalary = e.getSalary() + totalSalary;

            if (e instanceof ItTech) {
                itTechSalary = e.getSalary() + totalSalary;
                itTechCounter++;

            } else if (e instanceof Programmer) {
                programmerSalary = e.getSalary() + programmerSalary;
                programmerCounter++;

            } else if (e instanceof Janitor) {
                janitorSalary = e.getSalary() + janitorSalary;
                janitorCounter++;

            } else if (e instanceof ProjectLeader) {
                projectLeaderSalary = e.getSalary() + projectLeaderSalary;
                projectLeaderCounter++;
            }
        }
        System.out.println("The average salary of the staff by profession: ");
        System.out.println("It-techs: " + itTechSalary / itTechCounter + "kr");
        System.out.println("Programmer: " + programmerSalary / programmerCounter + "kr");
        System.out.println("Janitor: " + janitorSalary / janitorCounter + "kr");
        System.out.println("ProjectLeader: " + projectLeaderSalary / projectLeaderCounter + "kr");
        System.out.println("\nThe average salary for the company in total is: " + totalSalary / employees.size() + "kr");
        pauseCode();
    }

    public static void averageSalaryWithStreams() {
        System.out.println("\nThe average salary of the staff by profession: ");
        System.out.println("Programmers: " + (f.format(statSalaryProgrammers.getAverage())) + "kr");
        System.out.println("It-Techs: " + (f.format(statSalaryItTech.getAverage())) + "kr");
        System.out.println("Janitors: " + (f.format(statSalaryItJanitor.getAverage())) + "kr");
        System.out.println("ProjectLeaders: " + (f.format(statSalaryProjectLeader.getAverage())) + "kr");
        System.out.println("\nAverage salary of the whole staff is " + (f.format(salaryStatAll.getAverage())) + "kr");
        pauseCode();
    }

}
