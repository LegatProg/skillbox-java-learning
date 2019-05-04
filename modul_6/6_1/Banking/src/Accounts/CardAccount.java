package Accounts;

public class CardAccount extends BankAccount {

    private final double COMMISSION = 0.1;

    public CardAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public void withdrawMoney(long amount) {
        long amountWithCommission = amount + Math.round(amount * COMMISSION);
        System.out.println(amountWithCommission + " will be withdraw, because of 1% withdrawal commission");
        super.withdrawMoney(amountWithCommission);
    }
}
