package staffManagement;

import java.io.Serializable;

public abstract class Employee implements Comparable<Employee>, Serializable {

    private String name;
    private int salary;
    private String gender;
    private int monthsWorked;
    private final int id;

    public static int counter = 0;

    public Employee(String name, int salary, String gender, int monthsWorked) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.monthsWorked = monthsWorked;
        this.id = counter++;
    }

    public int compareTo(Employee e) {
        return this.getSalary() - e.getSalary();
    }

    public abstract void assignBonus(Employee e);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMonthsWorked() {
        return monthsWorked;
    }

    public void setMonthsWorked(int monthsWorked) {
        this.monthsWorked = monthsWorked;
    }

    public int getId() {
        return id;
    }


}
