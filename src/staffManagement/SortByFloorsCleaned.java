package staffManagement;

import java.util.Comparator;

public class SortByFloorsCleaned implements Comparator<Employee> {

    @Override
    public int compare(Employee j1, Employee j2) {
        if (j1 instanceof Janitor && j2 instanceof Janitor){
            return ((Janitor) j1).getMonthlyFloorsCleaned() - ((Janitor) j2).getMonthlyFloorsCleaned();
        }else return 0;

    }
}
