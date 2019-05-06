package bank.clients;

public class Person extends Client {

    @Override
    public void depositMoney(long amount) {
        account += amount;
    }
}
