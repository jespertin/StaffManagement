package staffManagement;

public class ItTech extends Employee {

    private int monthlyIssuesSolved;

    public ItTech(String name, int salary, String gender, int monthsWorked, int monthlyIssuesSolved) {
        super(name, salary, gender, monthsWorked);
        this.monthlyIssuesSolved = monthlyIssuesSolved;
    }

    public void assignBonus(Employee e) {
        int bonus = ((ItTech) e).monthlyIssuesSolved * 50;
        e.setSalary(e.getSalary() + bonus);
        System.out.println("Bonus of " + bonus + "kr assigned to " + e.getName());
        Utilities.pauseCode();
    }

    public int getMonthlyIssuesSolved() {
        return monthlyIssuesSolved;
    }

    public void setMonthlyIssuesSolved(int monthlyIssuesSolved) {
        this.monthlyIssuesSolved = monthlyIssuesSolved;
    }
}
