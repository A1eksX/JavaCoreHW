package task2;

import task2.exceprions.AmountException;
import task2.exceprions.CustomerException;
import task2.exceprions.ProductException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * В класс покупателя добавить перечисление с гендерами, добавить в покупателя свойство «пол» со значением
     * созданного перечисления. Добавить геттеры, сеттеры.
     * Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля),
     * написать метод, принимающий массив покупателей, поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта,
     * а мужчин с 23 февраля, если сегодня соответствующий день.
     */

    public static void main(String[] args) throws CustomerException, AmountException, ProductException {

        OnlineShop.getCustomerList().add(new Customer("Ivanov", LocalDate.of(1986, 12, 3), "+772165", Gender.MALE));
        OnlineShop.getCustomerList().add(new Customer("Petrova", LocalDate.of(1972, 3, 27), "+76215615", Gender.FEMALE));
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
//        LocalDate currentDate = LocalDate.now();
//        int month = currentDate.getMonthValue();
//        int day = currentDate.getDayOfMonth();
//
//
//        System.out.println(month);
//        System.out.println(day);
        СongratulationsOnTheHoliday(OnlineShop.getCustomerList());
    }

    public static void СongratulationsOnTheHoliday (List<Customer> customer){
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        if (day == 1 && month == 1){
                System.out.println("Поздравляем ВСЕХ с " + Holidays.NEW_YEARS );
            } else if (day == 8 && month == 3){
                for (Customer unit: customer) {
                    if (unit.getGender().equals(Gender.FEMALE)){
                        System.out.println("Поздравляем "+ unit.getFIO()+ " c " + Holidays.EATCH_OF_MARTH);
                    }
                }
            } else if (day == 23 && month == 2){
                for (Customer unit: customer) {
                    if (unit.getGender().equals(Gender.MALE)){
                        System.out.println("Поздравляем "+ unit.getFIO()+ " c " + Holidays.TWENTY_THREE_OF_FEBRUARY);
                    }
                }
            }else {
                System.out.println(Holidays.NO_HOLIDAY);
            }
    }
}
