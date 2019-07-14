package employees;

import company.Company;

public abstract class AbsEmployee implements Employee, Comparable<AbsEmployee> {

    private String name;
    protected long monthSalary;
    private Company company;

    public AbsEmployee(String name) {
        this.name = name;
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

        Long thisSalary = this.getMonthSalary();
        Long objSalary = o.getMonthSalary();
        if (thisSalary.compareTo(objSalary) == 0) {
            return getName().compareTo(o.getName());
        } else {
            return thisSalary.compareTo(objSalary);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getName() + " - " + getMonthSalary() / 100;
    }
}
