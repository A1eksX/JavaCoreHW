package task2.exceprions;

import task2.Order;

public class AmountException extends Exception {
    private String customer;
    private String product;
    public AmountException(String customer, String product){
        this.customer = customer;
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public AmountException(String message) {
        super(message);
    }
}
