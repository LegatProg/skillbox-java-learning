package employees;

public class TopManager extends AbsEmployee {

    private final int FIXED_PART = 120_000_00;   // коп
    private final long COM_INCOME_TO_GET_BENEFIT = 10_000_000_00; //коп
    private final double BENEFIT_PERCENT = 0.02;

    public TopManager(String name) {
        super(name);
        setHierarchyId(0);
    }

    public void setMonthSalary() {
        if (getCompany().getMonthIncome() > COM_INCOME_TO_GET_BENEFIT) {
            setSalaryWithBenefit();
        } else {
            setSalaryWithoutBenefit();
        }
    }

    private void setSalaryWithBenefit() {
        monthSalary = FIXED_PART + (int) Math.ceil(getCompany().getMonthIncome() * BENEFIT_PERCENT);
    }

    private void setSalaryWithoutBenefit() {
        monthSalary = FIXED_PART;
    }
}
