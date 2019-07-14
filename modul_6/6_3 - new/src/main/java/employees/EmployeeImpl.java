package employees;

import org.jetbrains.annotations.NotNull;

public class EmployeeImpl implements Employee, Comparable<EmployeeImpl> {

    private String name;
    private long fixedSalary;
    private Hierarchy position;

    public EmployeeImpl(String name, Hierarchy position, long fixedSalary) {
        this.name = name;
        this.position = position;
        this.fixedSalary = fixedSalary;
    }

    public Integer getHierarchyId() {
        return position.getHierarchy();
    }

    public Hierarchy getPosition() {
        return position;
    }

    @Override
    public long getFixedSalary() {
        return fixedSalary;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NotNull EmployeeImpl o) {
        if (this.getHierarchyId().equals(o.getHierarchyId())) {
            Long thisSalary = this.getFixedSalary();
            Long objSalary = o.getFixedSalary();
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
        return position + ": " + getName();
    }
}
