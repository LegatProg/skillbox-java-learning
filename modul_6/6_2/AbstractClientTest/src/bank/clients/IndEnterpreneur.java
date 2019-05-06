package bank.clients;

public class IndEnterpreneur extends Client {

    private final double BIG_COMMISSION = 0.01;
    private final double SMALL_COMMISSION = 0.005;

    @Override
    public void depositMoney(long amount) {
        if (amount < 1000) {
            account += amount - amount * BIG_COMMISSION;
        } else {
            account += amount - amount * SMALL_COMMISSION;
        }
    }
}
