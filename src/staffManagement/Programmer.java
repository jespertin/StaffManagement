package staffManagement;

public class Programmer extends Employee {

    private int monthlyBugsInCode;

    public Programmer(String name, int salary, String gender, int monthsWorked, int monthlyBugsInCode) {
        super(name, salary, gender, monthsWorked);
        this.monthlyBugsInCode = monthlyBugsInCode;
    }

    public void assignBonus(Employee e) {
        int bonus = 5000 - ((Programmer) e).monthlyBugsInCode * 50;
        e.setSalary(e.getSalary() + bonus);
        System.out.println("Bonus of " + bonus + "kr assigned to " + e.getName());
        Utilities.pauseCode();
    }

    public int getMonthlyBugsInCode() {
        return monthlyBugsInCode;
    }

    public void setMonthlyBugsInCode(int monthlyBugsInCode) {
        this.monthlyBugsInCode = monthlyBugsInCode;
    }
}
