package bank.clients;

public abstract class Client {

    protected long account;

    public void withdrawMoney(long amount) {
        if (isEnoughMoney(amount)) {
            account -= amount;
        } else {
            System.out.println("Not enough money!");
        }
    }

    public abstract void depositMoney(long amount);

    public long getAccount() {
        return account;
    }

    boolean isEnoughMoney(long amount) {
        return account - amount >= 0;
    }
}
