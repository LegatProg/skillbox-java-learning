public class BankingOperation {

    private String accountType;
    private String accountNumber;
    private String currency;
    private String operationDate;
    private String wiringReference;
    private String operationDescription;
    private long income;
    private long expense;

    public BankingOperation(String accountType, String accountNumber, String currency, String operationDate,
                            String wiringReference, String operationDescription, long income, long expense) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.operationDate = operationDate;
        this.wiringReference = wiringReference;
        this.operationDescription = operationDescription;
        this.income = income;
        this.expense = expense;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getWiringReference() {
        return wiringReference;
    }

    public void setWiringReference(String wiringReference) {
        this.wiringReference = wiringReference;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public long getExpense() {
        return expense;
    }

    public void setExpense(long expense) {
        this.expense = expense;
    }

    public String getDescription() {
        String desc = operationDescription.replaceAll
                ("^\\S+\\s+\\d*\\\\?/?\\d*\\s*/*\\\\*.+[\\\\/]", ""); //cut the 1st part of the string
        desc = desc.replaceAll("\\s\\d{2}\\..+", ""); //cut the end of the string;
        desc = desc.replaceAll(">MOSCOW",""); //cut >MOSCOW
        return desc.trim(); //
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("accountType: ").append(accountType).append(" ");
        sb.append("accountNumber: ").append(accountNumber).append(" ");
        sb.append("currency: ").append(currency).append(" ");
        sb.append("operationDate: ").append(operationDate).append(" ");
        sb.append("wiringReference: ").append(wiringReference).append(" ");
        sb.append("operationDescription: ").append(operationDescription).append(" ");
        sb.append("income: ").append(income).append(" ");
        sb.append("expense: ").append(expense);
        return sb.toString();
    }
}
