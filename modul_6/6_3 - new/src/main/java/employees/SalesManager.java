package employees;

import company.Company;

public class SalesManager implements Employee {
    private String name;
    private long fixedSalaryPart;
    private long benefitSalaryPart;

    private final double BENEFIT_PERCENT = 0.05;

    public SalesManager(String name, long fixedSalaryPart) {
        this.name = name;
        this.fixedSalaryPart = fixedSalaryPart;
    }

    private long getBenefitSalaryPart (long earnedMoney){
        benefitSalaryPart = (long)(BENEFIT_PERCENT * earnedMoney);
        return benefitSalaryPart;
    }

    public long getSalary(long earnedMoney){
        return fixedSalaryPart + getBenefitSalaryPart(earnedMoney);
    }
}
