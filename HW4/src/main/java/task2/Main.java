package task2;

import task2.exceprions.AmountException;
import task2.exceprions.CustomerException;
import task2.exceprions.ProductException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    /**
     * Задача: Эмуляция интернет-магазина
     * 1. написать классы покупатель, товар и заказ;
     * 2. создать массив покупателей, массив товаров и массив заказов;
     * 3. создать статический метод “совершить покупку” со строковыми
     * параметрами, соответствующими полям объекта заказа. Метод
     * должен вернуть объект заказа
     * 4. Если в метод передан несуществующий покупатель, товар или
     * отрицательное количество, метод должен выбросить
     * соответствующее исключение;
     * 5. Вызвать метод совершения покупки несколько раз таким образом,
     * чтобы заполнить массив покупок возвращаемыми значениями.
     * Обработать исключения.
     * 6. Вывести в консоль итоговое количество совершённых покупок после
     * выполнения приложения.
     */

    public static void main(String[] args) throws CustomerException, AmountException, ProductException {

        OnlineShop.getCustomerList().add(new Customer("Ivanov", LocalDate.of(1986, 12, 3), "+772165"));
        OnlineShop.getCustomerList().add(new Customer("Petrov", LocalDate.of(1972, 3, 27), "+76215615"));
        OnlineShop.getProductList().add(new Product("Chees", BigDecimal.valueOf(720L)));
        OnlineShop.getProductList().add(new Product("Масло", BigDecimal.valueOf(145L)));


        try {
            Order order = null;
            order = OnlineShop.buyProduct("Ivanov", "Chees", "700");

        OnlineShop.getOrderList().add(order);
            System.out.println(OnlineShop.getOrderList());

            Order order2 = OnlineShop.buyProduct("Ivanov", "Chees", "700");
            OnlineShop.getOrderList().add(order2);
            System.out.println(OnlineShop.getOrderList());

            Order order3 = OnlineShop.buyProduct("Petrov", "Chees", "300");
            OnlineShop.getOrderList().add(order3);
        } catch (AmountException e) {
            OnlineShop.getOrderList().add(OnlineShop.buyProduct(e.getCustomer(), e.getProduct(), "1"));
        } catch (ProductException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            throw e;
        }

            System.out.println(OnlineShop.getOrderList());



        System.out.println(OnlineShop.getOrderList().size() + " orders received");

    }
}
