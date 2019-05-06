package bank.clients;

public class IndEnterpreneur extends Client {

    private final double BIG_COMMISSION = 0.01;
    private final double SMALL_COMMISSION = 0.005;
    private final int CHECK_AMOUNT = 1000;

    @Override
    public void depositMoney(long amount) {
        if (amount < CHECK_AMOUNT) {
            account += amount - amount * BIG_COMMISSION;
        } else {
            account += amount - amount * SMALL_COMMISSION;
        }
    }
}
