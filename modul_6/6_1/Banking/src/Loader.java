import Accounts.CardAccount;
import Accounts.DepositAccount;

public class Loader {
    public static void main(String[] args) {
        DepositAccount depAcc = new DepositAccount("Alein Delon");
        CardAccount cardAcc = new CardAccount("Marilyn Monroe");


        depAcc.depositMoney(1_000_000);
        depAcc.withdrawMoney(100_000);
        System.out.println(depAcc.getOwnerName() + " money amount is: " + depAcc.getMoneyAmount());

        cardAcc.depositMoney(2_000_000);
        cardAcc.withdrawMoney(150_000);
        System.out.println(cardAcc.getOwnerName() + " money amount is: " + cardAcc.getMoneyAmount());

    }
}
