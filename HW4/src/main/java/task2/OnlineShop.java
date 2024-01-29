package task2;

import lombok.Data;
import task2.exceprions.AmountException;
import task2.exceprions.CustomerException;
import task2.exceprions.ProductException;

import java.util.ArrayList;
import java.util.List;
@Data

public class OnlineShop {
    private static List<Customer> customerList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();
    private static List<Order> orderList = new ArrayList<>();

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    //    public OnlineShop(List<Customer> customerList, List<Product> productList, List<Order> orderList) {
//        this.customerList = customerList;
//        this.productList = productList;
//        this.orderList = orderList;
//    }

    public static Order buyProduct(String customerFIO, String productName, String quantityOfProducts) throws AmountException, CustomerException, ProductException {
        Customer currentCustomer = null;
        for (Customer unit: customerList) {
            if (unit.getFIO().equals(customerFIO)){
                currentCustomer = unit;
                break;
            }
        }
        Product currentProduct = null;
        for (Product item: productList) {
            if (item.getName().equals(productName)){
                currentProduct = item;
                break;
            }
        }
        int currentQuantity = Integer.parseInt(quantityOfProducts);
        if (currentQuantity <= 0 || currentQuantity > 100){
            throw new AmountException(customerFIO, productName);
        }
        if (currentCustomer == null){
            throw  new CustomerException();
        }
        if (currentProduct == null){
            throw  new ProductException();
        }
        return new Order(currentCustomer, currentProduct, currentQuantity);
    }
}
