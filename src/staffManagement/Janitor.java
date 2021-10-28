package staffManagement;

public class Janitor extends Employee {

    private int monthlyFloorsCleaned;

    public Janitor(String name, int salary, String gender, int monthsWorked, int monthlyFloorsCleaned) {
        super(name, salary, gender, monthsWorked);
        this.monthlyFloorsCleaned = monthlyFloorsCleaned;
    }

    public void assignBonus(Employee e) {
        int bonus = ((Janitor) e).monthlyFloorsCleaned * 20;
        e.setSalary(e.getSalary() + bonus);
        System.out.println("Bonus of " + bonus + "kr assigned to " + e.getName());
        Utilities.pauseCode();
    }

    public int getMonthlyFloorsCleaned() {
        return monthlyFloorsCleaned;
    }

    public void setMonthlyFloorsCleaned(int monthlyFloorsCleaned) {
        this.monthlyFloorsCleaned = monthlyFloorsCleaned;
    }
}
