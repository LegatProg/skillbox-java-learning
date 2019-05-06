package bank.clients;

public class LegalEntity extends Client {

    private final float COMMISSION = 0.01f;

    @Override
    public void withdrawMoney(long amount) {
        amount += amount * COMMISSION;
        super.withdrawMoney(amount);
    }

    @Override
    public void depositMoney(long amount) {
        account += amount;
    }
}
