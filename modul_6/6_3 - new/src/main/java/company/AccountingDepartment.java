package company;

import employees.EmployeeImpl;
import employees.Hierarchy;
import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

public class AccountingDepartment {

    private long companyMothIncome;
    private TreeMap<EmployeeImpl, Long> monthEarnings;

    private final long BASE_EARNED_MONEY = 5_000_000L;

    public void countEarnings(Company company) {
        monthEarnings = new TreeMap<>();
        company.getHrDepartment().getEmployees().stream()
                .filter(e -> e.getHierarchyId().equals(Hierarchy.SALES_MANAGER))
                .forEach(e -> {
                    long earnedMoney = (long) (Math.random() * BASE_EARNED_MONEY);
                    monthEarnings.put(e, earnedMoney);
                });
        companyMothIncome = monthEarnings.values().stream().mapToLong(v -> v).sum();
    }

    public long getCompanyMonthIncome(Company company) {
        countEarnings(company);
        return companyMothIncome;
    }

    private void countEmployeeSalary(@NotNull EmployeeImpl employee) {
        switch (employee.getPosition()) {
            case TOP_MANAGER: {
                final int FIXED_PART = 120_000_00;   // коп
                final long COM_INCOME_TO_GET_BENEFIT = 10_000_000_00; //коп
                final double BENEFIT_PERCENT = 0.02;

                if (getMonthIncome() > COM_INCOME_TO_GET_BENEFIT) {
                    employee.setFixedSalary(FIXED_PART + (int) Math.ceil(getMonthIncome() * BENEFIT_PERCENT));
                } else {
                    employee.setFixedSalary(FIXED_PART);
                }
                break;
            }
            case SALES_MANAGER: {
                final int FIXED_PART = 15_000_00;   //коп
                final double PERCENT = 0.05;
                long salary = FIXED_PART;
                if (salesManagersEarnedMoney.containsKey(employee)) {
                    salary += Math.ceil(salesManagersEarnedMoney.get(employee) * PERCENT);
                }
                employee.setFixedSalary(salary);
                break;
            }
            case CASHIER: {
                final int FIXED_PART = 30_000_00;   //коп
                employee.setFixedSalary(FIXED_PART);
                break;
            }
        }
    }
}
