package employees;

public class Cashier extends AbsEmployee {

    private static int FIXED_SALARY = 25_000_00; //коп

    public Cashier(String name) {
        super(name);
        setHierarchyId(2);
    }

    @Override
    public void setMonthSalary() {
        monthSalary = FIXED_SALARY;
    }
}
