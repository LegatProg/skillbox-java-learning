package company;

import employees.Employee;
import employees.EmployeeImpl;

import java.util.TreeSet;

public class HRDepartment {

    private TreeSet<EmployeeImpl> employees;

    public HRDepartment () {
        employees = new TreeSet<>();
    }

    public void hireEmployee (EmployeeImpl employee) {
        employees.add(employee);
    }

    public void dismissEmployee (EmployeeImpl employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else {
            throw new NullPointerException("Employee don't works in the company");
        }
    }

    public TreeSet<EmployeeImpl> getEmployees() {
        return employees;
    }
}
