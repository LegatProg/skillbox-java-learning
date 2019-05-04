package Accounts;

public class BankAccount {
    private String ownerName;
    private long moneyAmount;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.moneyAmount = 0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getMoneyAmount() {
        return moneyAmount;
    }

    public void withdrawMoney(long amount) {
        if (isEnoughMoney(amount)) {
            moneyAmount -= amount;
            System.out.println(amount + " was withdrawn.");
        } else {
            System.out.println("Not enough money!");
        }
    }

    public void depositMoney(long amount) {
        moneyAmount += amount;
    }

    protected boolean isEnoughMoney(long amount) {
        return moneyAmount - amount >= 0;
    }

}
