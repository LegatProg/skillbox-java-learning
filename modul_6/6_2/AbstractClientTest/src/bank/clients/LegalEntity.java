package bank.clients;

public class LegalEntity extends Client {

    private final float COMMISSION = 0.01f;

    @Override
    public void withdrawMoney(double amount) {
        amount += amount * COMMISSION;
        if (isEnoughMoney(amount)){
            account -= amount;
        } else {
            System.out.println("Not enough money!");
        }
    }

    @Override
    public void depositMoney(double amount) {
        account += amount;
    }
}
