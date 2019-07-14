package employees;

public enum Hierarchy {
    TOP_MANAGER(0),
    SALES_MANAGER(1),
    CASHIER(2);

    private int hierarchy;

    Hierarchy(int hierarchy) {
        this.hierarchy = hierarchy;
    }

    public int getHierarchy() {
        return hierarchy;
    }
}
