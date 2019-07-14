package company;

import employees.AbsEmployee;
import employees.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Company {

    private long monthIncome;
    private TreeSet<AbsEmployee> employees;

    public Company(long monthIncome) {
        this.monthIncome = monthIncome;
        employees = new TreeSet<>();
    }

    public void getTopSalaryStaff(int count) {
        printEmployeesWithSort(Comparator.comparing(Employee::getMonthSalary).reversed(), count);
    }

    public void getLowestSalaryStaff(int count) {
        printEmployeesWithSort(Comparator.comparing(Employee::getMonthSalary), count);
    }

    private void printEmployeesWithSort(Comparator<Employee> comparator, int limit) {
        ArrayList<AbsEmployee> list = new ArrayList<>(employees);
        if (employees.size() < limit) {
            System.out.println("Not enough people to print, printing all company employees");
        }
        list.stream()
                .sorted(comparator)
                .limit(limit)
                .forEach(System.out::println);
    }

    public void hireEmployee(AbsEmployee employee) {
        employee.setCompany(this);
        employee.setMonthSalary();
        employees.add(employee);
    }

    public void dismissEmployee(AbsEmployee employee) {
        employees.remove(employee);
    }

    public long getMonthIncome() {
        return monthIncome;
    }

}
