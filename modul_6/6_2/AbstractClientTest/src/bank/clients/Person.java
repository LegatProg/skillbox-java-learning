package bank.clients;

public class Person extends Client {
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
        account += amount;
    }
}
