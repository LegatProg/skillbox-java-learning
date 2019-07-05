import company.Company;
import employees.Cashier;
import employees.SalesManager;
import employees.TopManager;
import utils.Name;

public class Loader {

    public static void main(String[] args) {
        Company google = new Company(100_000_000_00L);

        for (int i = 0; i < 6; i++) {
            google.hireEmployee(new TopManager(Name.getRandomName()));
        }

        for (int i = 0; i < 100; i++) {
            google.hireEmployee(new SalesManager(Name.getRandomName(), (int) (10_000_000 * Math.random())));
        }

        for (int i = 0; i < 164; i++) {
            google.hireEmployee(new Cashier(Name.getRandomName()));
        }

        google.getLowestSalaryStaff(10);
        System.out.println("======================");
        google.getTopSalaryStaff(10);
    }


}
