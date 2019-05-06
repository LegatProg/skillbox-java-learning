package company;

import employees.AbsEmployee;
import utils.SalaryAscendingComparator;
import utils.SalaryDescendingComparator;

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
        printEmployeesWithSort(new SalaryDescendingComparator(), count);
    }

    public void getLowestSalaryStaff(int count) {
        printEmployeesWithSort(new SalaryAscendingComparator(), count);
    }

    private void printEmployeesWithSort(Comparator<AbsEmployee> comparator, int limit) {
        ArrayList<AbsEmployee> list = new ArrayList<>(employees);
        list.sort(comparator);
        if (limit <= employees.size()) {
            list.stream().limit(limit).forEach(System.out::println);
        } else {
            System.out.println("Not enough people to print, printing all company employees");
            list.forEach(System.out::println);
        }
    }

    public void hireEmployee(AbsEmployee employee) {
        employee.setCompany(this);
        employee.setMonthSalary();
        employees.add(employee);
    }

    public void dismissEmployee(AbsEmployee employee) {
        employees.remove(employee);
    }

    public void printEmployeesInNaturalSort() {
        employees.forEach(System.out::println);
    }

    public long getMonthIncome() {
        return monthIncome;
    }

}
