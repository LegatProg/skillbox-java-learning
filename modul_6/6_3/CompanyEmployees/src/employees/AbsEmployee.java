package employees;

import company.Company;

public abstract class AbsEmployee implements Employee, Comparable<AbsEmployee> {

    private String name;
    protected long monthSalary;
    private Company company;
    private int hierarchyId;

    public AbsEmployee(String name) {
        this.name = name;
    }

    public void setHierarchyId(int hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public Integer getHierarchyId() {
        return hierarchyId;
    }

    public abstract void setMonthSalary();

    @Override
    public long getMonthSalary() {
        return monthSalary;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int compareTo(AbsEmployee o) {

        if (this.getClass().equals(o.getClass())) {
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
        return getClass().getSimpleName() + ": " + getName() + " - " + getMonthSalary() / 100;
    }
}
