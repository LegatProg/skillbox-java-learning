package bank.clients;

public class IndEnterpreneur extends Client {

    private final float BIG_COMMISSION = 0.01f;
    private final float SMALL_COMMISSION = 0.005f;

    @Override
    public void withdrawMoney(double amount) {
        if (isEnoughMoney(amount)) {
            account -= amount;
        } else {
            System.out.println("Not enough money!");
        }
    }

    @Override
    public void depositMoney(double amount) {
        if (amount < 1000) {
            account += amount - amount * BIG_COMMISSION;
        } else {
            account += amount - amount * SMALL_COMMISSION;
        }
    }
}
