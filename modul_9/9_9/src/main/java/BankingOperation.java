public class BankingOperation {

    private String operationDescription;
    private long income;
    private long expense;

    public BankingOperation(String operationDescription, long income, long expense) {

        this.operationDescription = operationDescription;
        this.income = income;
        this.expense = expense;
    }

    public long getIncome() {
        return income;
    }

    public long getExpense() {
        return expense;
    }

    public String getDescription() {
        return operationDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("operationDescription: ").append(operationDescription).append(" ");
        sb.append("income: ").append(income).append(" ");
        sb.append("expense: ").append(expense);
        return sb.toString();
    }


}
