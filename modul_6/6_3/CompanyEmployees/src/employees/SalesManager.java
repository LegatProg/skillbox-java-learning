package employees;

public class SalesManager extends AbsEmployee {

    private final int FIXED_PART = 25_000_00;   //коп
    private final double PERCENT = 0.05;

    private long earnedMoney;

    public SalesManager(String name, long earnedMoney) {
        super(name);
        this.earnedMoney = earnedMoney;
    }

    @Override
    public void setMonthSalary() {
        monthSalary = FIXED_PART + (int) Math.ceil(earnedMoney * PERCENT);
    }
}
