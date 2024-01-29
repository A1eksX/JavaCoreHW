package task2;

import lombok.Data;

@Data
public class Order {
    private Customer customer;
    private Product product;
    private int quantity;

    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Order() {
    }

//    @Override
//    public String toString() {
//        return String.format("buyer: %s, product: %s, count: %d", customer, product, quantity);
//    }
}
