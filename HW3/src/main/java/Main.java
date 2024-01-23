import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee(
                "Ivan Ivan",
                "Dev1",
                "+765461",
                BigDecimal.valueOf(10000),
                LocalDate.of(1990, 1, 11));
        Employee employee2 = new Employee(
                "Petrov Petrov",
                "Dev2",
                "+765461",
                BigDecimal.valueOf(20000),
                LocalDate.of(1990, 1, 1));
        Employee employee3 = new Employee(
                "Sidorov Petrov",
                "Dev3",
                "+765461",
                BigDecimal.valueOf(30000),
                LocalDate.of(1990, 1, 1));
        Employee employee4 = new Employee(
                "Ivan Sidorovov",
                "Dev4",
                "+765461",
                BigDecimal.valueOf(50000),
                LocalDate.of(1990, 1, 1));
        Employee employee5 = new Employee(
                "Sidor Sidorovov",
                "Dev5",
                "+765461",
                BigDecimal.valueOf(86150),
                LocalDate.of(1975, 1, 1));
        Director director = new Director(
                "Pavel Pavlov",
                "Director",
                "+765461",
                BigDecimal.valueOf(200000),
                LocalDate.of(1965, 1, 1));

        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4, employee5, director));
        for (Employee e: employees ) {
            System.out.println(e);
        }

        director.increaseSalaryForColective(employees, 30000);

        System.out.println("============");
        for (Employee e: employees ) {
            System.out.println(e);
        }
    }
}
