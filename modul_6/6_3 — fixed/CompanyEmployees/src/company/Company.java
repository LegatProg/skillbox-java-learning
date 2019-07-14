package company;

import employees.Employee;
import employees.EmployeeImpl;
import employees.Hierarchy;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Company {

    private long monthIncome;
    private TreeSet<EmployeeImpl> employees = new TreeSet<>();
    private HashMap<EmployeeImpl, Long> salesManagersEarnedMoney = new HashMap<>();

    public Company(long monthIncome) {
        this.monthIncome = monthIncome;
    }

    private void putToEarnedMoneyMap(@NotNull EmployeeImpl salesManager, long earnedMoney) {
        if (salesManager.getPosition().equals(Hierarchy.SALES_MANAGER)) {
            salesManagersEarnedMoney.put(salesManager, earnedMoney);
        } else {
            System.out.println("Error! Employee's position is not a SALES MANAGER!");
        }
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

    public void countSalesManagersEarnedMoney() {
        final long BASE_EARNED_MONEY = 5_000_000_00L;
        employees.stream()
                .filter(e -> e.getPosition().equals(Hierarchy.SALES_MANAGER))
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(e -> putToEarnedMoneyMap(e, (long) (Math.random() * BASE_EARNED_MONEY))
                );
    }

    public void countStuffMonthSalaries() {
        employees.forEach(this::countEmployeeSalary);
    }

    public long getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(long monthIncome) {
        this.monthIncome = monthIncome;
    }

    public TreeSet<EmployeeImpl> getEmployees() {
        return employees;
    }

    public void getTopSalaryStaff(int count) {
        printEmployeesWithSort(Comparator.comparing(Employee::getFixedSalary).reversed(), count);
    }

    public void getLowestSalaryStaff(int count) {
        printEmployeesWithSort(Comparator.comparing(Employee::getFixedSalary), count);
    }

    private void printEmployeesWithSort(Comparator<Employee> comparator, int limit) {
        ArrayList<EmployeeImpl> list = new ArrayList<>(employees);
        if (employees.size() < limit) {
            System.out.println("Not enough people to print, printing all company employees");
        }
        list.stream()
                .sorted(comparator)
                .limit(limit)
                .forEach(System.out::println);
    }

    public void printEmployeesInNaturalSort() {
        employees.forEach(System.out::println);
    }

    public void hireEmployee(EmployeeImpl employee) {
        countEmployeeSalary(employee);
        employees.add(employee);
    }

    public void dismissEmployee(EmployeeImpl employee) {
        employees.remove(employee);
    }
}
