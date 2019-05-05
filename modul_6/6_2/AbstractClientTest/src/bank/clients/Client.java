package bank.clients;

public abstract class Client {

    double account;

    public abstract void withdrawMoney(double amount);

    public abstract void depositMoney(double amount);

    public double getAccount() {
        return account;
    }

    boolean isEnoughMoney(double amount) {
        return account - amount >= 0;
    }
}
