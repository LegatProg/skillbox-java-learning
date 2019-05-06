package utils;

import employees.AbsEmployee;

import java.util.Comparator;

public class SalaryAscendingComparator implements Comparator<AbsEmployee> {
    @Override
    public int compare(AbsEmployee o1, AbsEmployee o2) {
        Long o1Salary = o1.getMonthSalary();
        Long o2Salary = o2.getMonthSalary();
        return o1Salary.compareTo(o2Salary);
    }
}
