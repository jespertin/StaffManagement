package staffManagement;

public class ProjectLeader extends Employee {

    private int monthlyEmployeeComplaints;
    private int monthlyProjectsComplete;

    public ProjectLeader(String name, int salary, String gender, int monthsWorked,
                         int monthlyEmployeeComplaints, int monthlyProjectsComplete) {

        super(name, salary, gender, monthsWorked);
        this.monthlyEmployeeComplaints = monthlyEmployeeComplaints;
        this.monthlyProjectsComplete = monthlyProjectsComplete;
    }

    public void assignBonus(Employee e) {
        int bonus = 2500 * ((ProjectLeader) e).monthlyProjectsComplete - ((ProjectLeader) e).monthlyEmployeeComplaints * 50;
        e.setSalary(e.getSalary() + bonus);
        System.out.println("Bonus of " + bonus + "kr assigned to " + e.getName());
        Utilities.pauseCode();

    }

    public int getMonthlyEmployeeComplaints() {
        return monthlyEmployeeComplaints;
    }

    public void setMonthlyEmployeeComplaints(int monthlyEmployeeComplaints) {
        this.monthlyEmployeeComplaints = monthlyEmployeeComplaints;
    }

    public int getMonthlyProjectsComplete() {
        return monthlyProjectsComplete;
    }

    public void setMonthlyProjectsComplete(int monthlyProjectsComplete) {
        this.monthlyProjectsComplete = monthlyProjectsComplete;
    }
}
