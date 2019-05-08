package employees;

import org.jetbrains.annotations.NotNull;

public class EmployeeImpl implements Employee, Comparable<EmployeeImpl> {

    private String name;
    private long monthSalary;
    private Hierarchy position;

    public EmployeeImpl(String name, Hierarchy position) {
        this.name = name;
        this.position = position;
    }

    public void setMonthSalary(long salary) {
        monthSalary = salary;
    }

    public Integer getHierarchyId() {
        return position.getHierarchy();
    }

    public Hierarchy getPosition() {
        return position;
    }

    @Override
    public long getMonthSalary() {
        return monthSalary;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NotNull EmployeeImpl o) {
        if (this.getHierarchyId().equals(o.getHierarchyId())) {
            Long thisSalary = this.getMonthSalary();
            Long objSalary = o.getMonthSalary();
            if (thisSalary.compareTo(objSalary) == 0) {
                return getName().compareTo(o.getName());
            } else {
                return thisSalary.compareTo(objSalary);
            }
        } else {
            return getHierarchyId().compareTo(o.getHierarchyId());
        }
    }

    @Override
    public String toString() {
        return position + ": " + getName() + " - " + getMonthSalary() / 100;
    }
}
