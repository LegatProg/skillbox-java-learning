package Accounts;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;

public class DepositAccount extends BankAccount {

    private LocalDate lastDepositDate;

    public DepositAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public void withdrawMoney(long amount) {
        if (lastDepositDate.until(LocalDate.now(), MONTHS) > 0) {
            super.withdrawMoney(amount);
        } else {
            System.out.println("You can't withdraw a money if your last deposit was less than 1 month ago!");
        }

    }

    @Override
    public void depositMoney(long amount) {
        super.depositMoney(amount);
        lastDepositDate = LocalDate.now();
    }
}


//startDate.until(endDate, DAYS)