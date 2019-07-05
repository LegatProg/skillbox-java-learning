import company.Company;
import employees.EmployeeImpl;
import employees.Hierarchy;
import utils.Name;

import java.util.ArrayList;

public class Loader {

    public static void main(String[] args) {
        final long GOOGLE_BASE_MONTH_INCOME = 100_000_000_00L;
        Company google = new Company(GOOGLE_BASE_MONTH_INCOME);

        for (int i = 0; i < 3; i++) {
            google.hireEmployee(new EmployeeImpl(Name.getRandomName(), Hierarchy.TOP_MANAGER));
        }

        for (int i = 0; i < 100; i++) {
            google.hireEmployee(new EmployeeImpl(Name.getRandomName(), Hierarchy.SALES_MANAGER));
        }

        for (int i = 0; i < 164; i++) {
            google.hireEmployee(new EmployeeImpl(Name.getRandomName(), Hierarchy.CASHIER));
        }

        System.out.println("After stuffing: ");
        google.printEmployeesInNaturalSort();

        System.out.println("==========================================================================");
        System.out.println("After first month: ");

        google.setMonthIncome(GOOGLE_BASE_MONTH_INCOME + (long) ((Math.random() - 0.5) * GOOGLE_BASE_MONTH_INCOME * 0.2));
        google.countSalesManagersEarnedMoney();
        google.countStuffMonthSalaries();

        google.getLowestSalaryStaff(10);
        System.out.println("===========================");
        google.getTopSalaryStaff(10);
        System.out.println("==========================================================================");

        System.out.println("After second month: ");
        google.setMonthIncome(GOOGLE_BASE_MONTH_INCOME + (long) ((Math.random() - 0.5) * GOOGLE_BASE_MONTH_INCOME * 0.2));
        google.countSalesManagersEarnedMoney();
        google.countStuffMonthSalaries();


        dismiss5PercentsOfStuff(google);
        System.out.println("==========================================================================");
        google.getLowestSalaryStaff(10);
        System.out.println("===========================");
        google.getTopSalaryStaff(10);

    }

    private static void dismiss5PercentsOfStuff(Company company) {
        System.out.println("DISMISS WAVE:");
        ArrayList<EmployeeImpl> list = new ArrayList<>(company.getEmployees());
        for (int i = 0; i < list.size() * 0.05; i++) {
            int x = (int) (Math.random() * list.size());
            System.out.println(list.get(x).getName() + " was dismissed");
            company.dismissEmployee(list.get(x));
            list.remove(x);
        }
    }
}
